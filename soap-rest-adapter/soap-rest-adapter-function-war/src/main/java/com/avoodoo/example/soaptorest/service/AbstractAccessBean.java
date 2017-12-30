package com.avoodoo.example.soaptorest.service;

import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceClient;

import org.apache.log4j.Logger;

import com.avoodoo.example.server.config.ApplicationConfig;

/**
 * Abstract super class for different AccessBeans accessing FSCD / SAP-PI
 * 
 * @author frank
 *
 * @param <S> Type of the services
 * @param <P> Type of the ports
 */
public class AbstractAccessBean <S extends Service, P> {

	private static Logger LOG = Logger.getLogger(AbstractAccessBean.class);
	
	/** User for accessing the FSCD services */
	private static final String WS_USERNAME_PROPERTY = "ws.sappi.username";
	
	/** Password for accessing the FSCD services */
	private static final String WS_PASSORD_PROPERTY = "ws.sappi.password";
	
	private final Class<S> serviceClass;
	private final String wsdlName;
	private final String namespace;
	
	private final String urlProperty;
	
	private S service;
	private P port;
	
	
	/**
	 * Creates a new instance of this class
	 * @param serviceClass which implements the access to the SAP services
	 * @param wsdlName name of the local stored wsdl
	 * @param urlProperty location of the accessible / deployed service
	 */
	public AbstractAccessBean(Class<S> serviceClass, String wsdlName, String urlProperty) {
		this.serviceClass = serviceClass;
		this.wsdlName = wsdlName;
		this.urlProperty = urlProperty;
		
		WebServiceClient annotation = serviceClass.getAnnotation(WebServiceClient.class);
		this.namespace = annotation.targetNamespace();
	}
	
	/**
	 * @return the name of the service
	 */
	protected String getServiceName() {
		return serviceClass.getSimpleName();
	}
	
	/**
	 * Returns the web service port for the given URL
	 * @return the port
	 */
	@SuppressWarnings("unchecked")
	protected P getService() {
		if (null != port) {
			return port;
		}
		
		if (null == service) {
			service = initializeWebService();
			
			try {
				port = (P) serviceClass.getDeclaredMethod("getHTTPPort", (Class[]) null).invoke(service, (Object[])null);
			}
			catch(Exception e) {
				throw new RuntimeException("Error during creation of the servicePort object [1]");
			}
			String urlPropertyValue = ApplicationConfig.getValue(urlProperty, false);
			LOG.info("Connection to WebService: URL = " +urlPropertyValue);
			
			
			fillRequestContext(((BindingProvider)port).getRequestContext(), urlPropertyValue);
		}
		return port;
	}
	
	/**
	 * Initialization of the access to the chosen FSCD service
	 * @return the web service
	 */
	protected synchronized S initializeWebService() {
		if (null == service) {
			try {
				URL wsdlUrl = getClass().getClassLoader().getResource(wsdlName);
				QName qName = new QName(namespace, serviceClass.getSimpleName());
				service = serviceClass.getConstructor(URL.class, QName.class).newInstance(wsdlUrl, qName);
			}
			catch (Exception e) {
				throw new RuntimeException("Error during creation of the service object [2]");
			}			
		}
		
		return service;
	}
	
	protected void fillRequestContext(Map<String, Object> requestContext, String urlProperty) {
		requestContext.put(BindingProvider.USERNAME_PROPERTY, ApplicationConfig.getValue(WS_USERNAME_PROPERTY, false));
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, ApplicationConfig.getValue(WS_PASSORD_PROPERTY, false));
		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, urlProperty);
	}
	
}























