package com.avoodoo.example.service.soap.model.employee;

import java.time.LocalDate;

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
public class SapEmployee extends DefaultWs {

	private String firstName;
	private String lastName;
	private int personnelNumber;
	private LocalDate birthDate;
	private int abteilungsNummer;
	private SapGender gender;
	
}
