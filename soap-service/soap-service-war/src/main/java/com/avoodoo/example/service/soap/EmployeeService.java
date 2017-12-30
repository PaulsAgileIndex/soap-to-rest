package com.avoodoo.example.service.soap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import org.apache.log4j.Logger;

import com.avoodoo.example.service.soap.model.employee.SapEmployee;
import com.avoodoo.example.service.soap.model.employee.SapEmployeeRequest;
import com.avoodoo.example.service.soap.model.employee.SapEmployeeResponse;
import com.avoodoo.example.service.soap.model.employee.SapGender;
import com.avoodoo.example.service.soap.model.fault.WsFault;
import com.avoodoo.example.service.soap.model.fault.WsFaultInfo;
import com.avoodoo.example.service.util.DateFormatUtils;

@WebService(name = "EmployeeWs", serviceName = "EmployeeWebService", portName = "HTTP_Port", targetNamespace = "http://www.avoodoo.com/avoodoo-soap-service/EmployeeWebService")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class EmployeeService {
	
	private static Logger LOG = Logger.getLogger(EmployeeService.class);
	
	@WebMethod(action = "getEmployees")
	@WebResult(name = "EmployeeResponse")
	@PermitAll
	//@RolesAllowed(value = SoapServiceConstants.PERMISSION_EMPLOYEE_REQUEST)
	public SapEmployeeResponse getEmployees(@WebParam(name = "employeeRequest")SapEmployeeRequest employeeRequest) throws WsFault {
//		LOG.info(ApplicationConfig.getValue("service.soap.employee.location", true));
		try {		
			List<SapEmployee> employeeList = new ArrayList<>();
			SapEmployee employee = new SapEmployee();
			employee.setFirstName("Frank");
			employee.setLastName("Sprich");
			employee.setPersonnelNumber(100007);
			employee.setBirthDate(LocalDate.parse("1974-11-07", DateFormatUtils.DATE_FORMATTER));
			
			if (employeeRequest.getAbteilungsNummer() == 4) {
				throw new Exception("moeeeppp!");
			}
			
			employee.setAbteilungsNummer(employeeRequest.getAbteilungsNummer());
			employee.setGender(SapGender.MALE);
			LOG.info(employee);
			employeeList.add(employee);	
			
			SapEmployeeResponse response = new SapEmployeeResponse();
			response.setCountEmployeesInAbteilung(employeeList.size());
			response.setEmployees(employeeList);
			
			return response;
		}
		catch(Exception e) {
			WsFaultInfo info = new WsFaultInfo();
			info.setMalfuctionSystem("soap");
			info.setMessage(e.getMessage());
			throw new WsFault(e.getMessage(), info);
		}
	}

}
