package ru.softwerke.practice.app2019.controller.rest;

import jdk.nashorn.internal.objects.annotations.Getter;
import ru.softwerke.practice.app2019.filter.FilterCreator;
import ru.softwerke.practice.app2019.model.Customer;
import ru.softwerke.practice.app2019.service.Service;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Path("customer")
public class CustomerRestController {
    private Service<Customer> customerDataService;

    @Inject
    public CustomerRestController(Service<Customer> customerDataService){
        this.customerDataService = customerDataService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers(@Context UriInfo ui){
    	return customerDataService.getAll(FilterCreator.createCustomerFilter(ui));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer createCustomer(Customer customer) {
        customerDataService.put(customer);
        return customer;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") Integer id) {
        return customerDataService.getItemById(id);
    }
}