package com.avoodoo.example.service.soap.model.employee;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.avoodoo.example.service.soap.DefaultWs;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class SapEmployeeResponse extends DefaultWs {
	
	private int countEmployeesInAbteilung;
	@XmlElement
	private List<SapEmployee> employees;

}
