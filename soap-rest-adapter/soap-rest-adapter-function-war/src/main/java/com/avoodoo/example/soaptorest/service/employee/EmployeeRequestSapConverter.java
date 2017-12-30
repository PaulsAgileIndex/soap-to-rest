package com.avoodoo.example.soaptorest.service.employee;

import javax.inject.Named;

import com.avoodoo.example.integration.service.soap.employee.SapEmployeeRequest;
import com.avoodoo.example.nba.common.model.employee.EmployeeRequest;

/**
 * Mapper for the given type
 * 
 * @author frank
 *
 */
@Named
public class EmployeeRequestSapConverter {
	
	/**
	 * @param request EmployeeRequest
	 * @return SapEmployeeRequest
	 */
	public SapEmployeeRequest convert(EmployeeRequest request) {
		SapEmployeeRequest result = null;
		if (null != request) {
			result = new SapEmployeeRequest();
			result.setAbteilungsNummer(request.getAbteilungsNummer());
		}
		return result;
	}

}
