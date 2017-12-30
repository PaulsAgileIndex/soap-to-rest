package com.avoodoo.example.soaptorest.ws;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.avoodoo.example.nba.common.constants.RestConstants;
import com.avoodoo.example.nba.common.model.employee.EmployeeRequest;
import com.avoodoo.example.nba.common.model.employee.EmployeeResponse;
import com.avoodoo.example.soaptorest.service.HelloService;
import com.avoodoo.example.soaptorest.service.employee.EmployeeAccessBean;


@Path("/")
@Consumes("application/json;charset=utf-8")
@Produces("application/json;charset=utf-8")
public class EndpointRs {

	@Inject
	private HelloService helloService;
	
	@Inject
	private EmployeeAccessBean employeeAccessBean;

	@GET
	@Path("/json")
	public Response getHelloJSON() {
		return Response.ok(helloService.sayHello()).build();
	}
	
	@GET
	@Path("/getEmployeeRequest")
	public Response getEmployeeRequest() {
		EmployeeRequest request = new EmployeeRequest();
		request.setAbteilungsNummer(5);
		return Response.ok(request).build();
	}

	@POST
	@Path(RestConstants.GET_ALL_EMPLOYEES)
	public Response getAllEmployees(@NotNull EmployeeRequest request,
			@Context SecurityContext securityContext) throws Exception {
		EmployeeResponse response = employeeAccessBean.getAllEmployees(request);
		return Response.ok(response).build();
	}

}
