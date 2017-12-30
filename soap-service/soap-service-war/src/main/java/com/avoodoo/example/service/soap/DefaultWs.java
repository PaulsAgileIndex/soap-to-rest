package com.avoodoo.example.service.soap;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

import org.xml.sax.SAXException;

/**
 * Superclass for all request objects.
 * JAXB looks for the methods beforeUnmarshal and afterUnmarshal in the object annotated with @XmlRootElement or @XmlType
 * @author frank
 *
 */
public class DefaultWs {
	
	/**
	 * It will be cause unmarshalling failure thrown to client on first exception thrown by XmlAdapter
	 * @param unmarshaller
	 * @param parent
	 * @throws JAXBException
	 * @throws IOException
	 * @throws SAXException
	 */
	public void beforeUnmarshal(Unmarshaller unmarshaller, Object parent) throws JAXBException, IOException, SAXException {
		unmarshaller.setEventHandler(new DefaultValidationEventHandler());
	}

}
