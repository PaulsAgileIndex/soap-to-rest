package com.avoodoo.example.service.soap.model.employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.avoodoo.example.service.soap.DefaultWs;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class SapEmployeeRequest extends DefaultWs {
	
	private int abteilungsNummer;

}
