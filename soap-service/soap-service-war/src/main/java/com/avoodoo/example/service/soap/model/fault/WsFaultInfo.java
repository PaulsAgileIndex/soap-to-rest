package com.avoodoo.example.service.soap.model.fault;

import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlType
@Data
public class WsFaultInfo {

	private String messageType;
	private String messageId;
	private String message;
	private String malfuctionSystem;
	private String originalMalfunctionSystem;
	
}
