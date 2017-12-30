package com.avoodoo.example.soaptorest.service;

import lombok.Data;

@Data
public class SapServiceResult<R> {

	private String serviceName;
	private R result;
	
	public SapServiceResult(String serviceName) {
		this.serviceName = serviceName;
	}
	
}
