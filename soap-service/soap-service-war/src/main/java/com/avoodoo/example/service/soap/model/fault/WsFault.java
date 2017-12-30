package com.avoodoo.example.service.soap.model.fault;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebFault;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SOAP conforming WebService exception
 * @author frank
 *
 */
@SuppressWarnings("serial")
@WebFault
@Data
@EqualsAndHashCode(callSuper = false)
public class WsFault extends Exception {

	private WsFaultInfo faultInfo;
	
	/**
	 * Creates a new instance
	 * @param message - general description of the failure
	 * @param faultInfo - further information for the exception
	 */
	public WsFault(String message, WsFaultInfo faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}
	
	@XmlElement(required = true)
	public WsFaultInfo getFaultInfo() {
		return faultInfo;
	}
	
}
