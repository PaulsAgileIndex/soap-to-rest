package com.avoodoo.example.soaptorest.service.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import com.avoodoo.example.integration.service.soap.employee.SapEmployee;
import com.avoodoo.example.nba.common.model.employee.Employee;
import com.avoodoo.example.soaptorest.service.converter.DatumSapConverter;


@Named
public class EmployeeConverter {
	
	private DatumSapConverter datumSapConverter;
	
	@Inject
	public EmployeeConverter(DatumSapConverter datumSapConverter) {
		this.datumSapConverter = datumSapConverter;
	}

	public List<Employee> convert(List<SapEmployee> employees) {
		if (null == employees) {
			return new ArrayList<>();
		}
		return employees.stream().map(this::convert).collect(Collectors.toList());
	}
	
	public Employee convert(SapEmployee employee) {
		Employee result = null;
		if (null != employee) {
			result = new Employee();
			result.setAbteilungsNummer(employee.getAbteilungsNummer());
			result.setBirthDate(datumSapConverter.convert(employee.getBirthDate()));
			result.setFirstName(employee.getFirstName());
//			result.setGender(employee.getGender())
			result.setLastName(employee.getLastName());
			result.setPersonnelNumber(employee.getPersonnelNumber());
		}
		return result;
	}
	
}
