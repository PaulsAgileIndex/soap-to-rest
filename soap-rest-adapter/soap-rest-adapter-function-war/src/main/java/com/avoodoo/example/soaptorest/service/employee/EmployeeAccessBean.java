package com.avoodoo.example.soaptorest.service.employee;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.avoodoo.example.integration.service.soap.employee.EmployeeWebService;
import com.avoodoo.example.integration.service.soap.employee.EmployeeWs;
import com.avoodoo.example.integration.service.soap.employee.SapEmployeeRequest;
import com.avoodoo.example.integration.service.soap.employee.SapEmployeeResponse;
import com.avoodoo.example.nba.common.model.employee.EmployeeRequest;
import com.avoodoo.example.nba.common.model.employee.EmployeeResponse;
import com.avoodoo.example.soaptorest.service.AbstractAccessBean;
import com.avoodoo.example.soaptorest.service.SapServiceCall;
import com.avoodoo.example.soaptorest.service.SapServiceCallWrapper;


@Named
@Transactional(value = TxType.NOT_SUPPORTED)
public class EmployeeAccessBean extends AbstractAccessBean <EmployeeWebService, EmployeeWs>{
	
	private static final String WS_URL_PROPERTY = "service.soap.employee.location";
	private static final String WSDL_NAME = "wsdl/EmployeeWebService.wsdl";
	private EmployeeRequestSapConverter requestConverter;
	private EmployeeResponseSapConverter responseConverter;
	
	SapServiceCallWrapper<SapEmployeeResponse, Exception> employeeWrapper;
	
	@Inject
	public EmployeeAccessBean(EmployeeRequestSapConverter requestConverter, EmployeeResponseSapConverter responseConverter) {
		super(EmployeeWebService.class, WSDL_NAME, WS_URL_PROPERTY);
		this.requestConverter = requestConverter;
		this.responseConverter = responseConverter;
		
		employeeWrapper = new SapServiceCallWrapper<>(null, getServiceName());
	}

	
	public EmployeeResponse getAllEmployees(EmployeeRequest request) throws Exception {
		
		/* Convert request (REST to SAP) */
		SapEmployeeRequest sapRequest = requestConverter.convert(request);
		
		/* Call SAP */
		SapEmployeeResponse sapResponse = employeeWrapper.wrapCall(new SapServiceCall<SapEmployeeResponse>() {
			
			@Override
			public SapEmployeeResponse executeCall() throws Exception {
				return getService().getEmployees(sapRequest);
			}
		});
		
		/* Response convert (SAP to REST) */
		EmployeeResponse response = responseConverter.convert(sapResponse);
		return response;
	}
}
