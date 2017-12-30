package com.avoodoo.example.soaptorest.service;


public class SapServiceCallWrapper<R, E extends Exception> {

	private ExceptionAdapter<E> adapter;
	private String serviceName;
	
	public SapServiceCallWrapper(ExceptionAdapter<E> adapter,String serviceName) {
		this.adapter = adapter;
		this.serviceName = serviceName;
	}
	
	public R wrapCall(SapServiceCall<R> sapServiceCall) {
		SapServiceResult<R> serviceResult = new SapServiceResult<>(serviceName);
		try {
			serviceResult.setResult(sapServiceCall.executeCall());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceResult.getResult();
	}
	
}
