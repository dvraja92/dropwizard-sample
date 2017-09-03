package com.decipherzone.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.decipherzone.dropwizard.AppConstants;
import com.decipherzone.dropwizard.response.APIResponse;
import com.decipherzone.dropwizard.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 3/9/17 4:16 PM by Raja Dushyant Vashishtha
 * Sr. Software Engineer
 * rajad@decipherzone.com
 * Decipher Zone Softwares LLP
 * www.decipherzone.com
 */

@Path("/customer")
@Api(value = "/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private CustomerService customerService;

    @Inject
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    @Timed
    @ApiOperation(value = "List all Customers", notes = "List all Customers", response = APIResponse.class, responseContainer = "List")
    public APIResponse getAllMembers() {
        return new APIResponse.ResponseBuilder(Response.Status.OK.getStatusCode(), AppConstants.SUCCESS)
                .setMsg("Customers List")
                .setData(customerService.getAllCustomers())
                .build();
    }

}
