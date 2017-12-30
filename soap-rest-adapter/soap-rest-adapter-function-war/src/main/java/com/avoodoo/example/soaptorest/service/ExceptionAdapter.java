package com.avoodoo.example.soaptorest.service;

/**
 * The exceptions from SAP are equal for every service. But there are different generated classes per service. 
 * This adapter takes care of that we can implement a homogeneous exception handling.
 * @author frank
 *
 * @param <E> the type of the Exception
 */
public interface ExceptionAdapter<E extends Exception> {
	
	/**
	 * @param exception
	 * @return true, if the adapter can handle the given exception type
	 */
	boolean canAdapt(Exception exception);
	
	/**
	 * @param exception
	 * @param serviceName which potentially throws the exception
	 * @return
	 */
	Exception convert(E exception, String serviceName);
	
	/**
	 * @param exception
	 */
	void setException(E exception);

}
