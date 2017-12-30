package com.avoodoo.example.soaptorest.model;

import javax.inject.Named;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@Named
@XmlRootElement
public class Hello {
	
	private String greeting = "Hello YOU!";

}
