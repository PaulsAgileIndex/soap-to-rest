package com.avoodoo.example.soaptorest.service.employee;

import javax.inject.Inject;
import javax.inject.Named;

import com.avoodoo.example.integration.service.soap.employee.SapEmployeeResponse;
import com.avoodoo.example.nba.common.model.employee.EmployeeResponse;

/**
 * Mapper for the given type
 * 
 * @author frank
 *
 */
@Named
public class EmployeeResponseSapConverter {
	
	private EmployeeConverter employeeConverter;
	
	/**
	 * Creates a new instance of this class
	 * @param employeeConverter - a converter
	 */
	@Inject
	public EmployeeResponseSapConverter(EmployeeConverter employeeConverter) {
		this.employeeConverter = employeeConverter;
	}
	
	/**
	 * @param response SapEmployeeResponse
	 * @return EmployeeResponse
	 */
	public EmployeeResponse  convert(SapEmployeeResponse response) {
		EmployeeResponse result = null;
		if (null != response) {
			result = new EmployeeResponse();
			result.setEmployees(employeeConverter.convert(response.getEmployees()));
		}
		return result;
	}

}
