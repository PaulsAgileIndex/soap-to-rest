package com.avoodoo.example.soaptorest.service;


/**
 * Interface which will be given to SapServiceCallWrapper which abstracts the SAP service call.
 * 
 * Example:
 * 
 * <pre>
 *  {@code}	
 * 	ZEVGENERATEESR request = esrDataRequestConverter.convert(request);
 *   
 *  ZEVGENERATEESRResponse response = sapWrapper.wrapCall(new SapServiceCall() {
 *  
 *  	public ZEVGENERATEESRResponse doIt() throws Exception {
 *  		return getService().siESRSYNOUT(request);
 *      }
 *  
 *  });
 *  
 *  return esrDataConverter.convert(response);
 * 
 * </pre>
 * 
 * @param <R> return type expected from the service call
 * 
 * @author frank
 *
 */
public interface SapServiceCall<T> {

	/**
	 * @return the answer
	 * @throws Exception will be thrown in the error case
	 */
	T executeCall() throws Exception;
	
}
