package com.avoodoo.example.service.soap.model.employee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Gender")
@XmlEnum
public enum SapGender {
	
	FEMALE, MALE, INTER;

}
