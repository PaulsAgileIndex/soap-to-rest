package com.avoodoo.example.soaptorest.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.avoodoo.example.soaptorest.model.Hello;

@Named
public class HelloService {
	
	@Inject
	private Hello hello;
	
	public Hello sayHello() {
		return hello;
	}

}
