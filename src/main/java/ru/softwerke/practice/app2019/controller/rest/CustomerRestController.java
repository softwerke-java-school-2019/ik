package ru.softwerke.practice.app2019.controller.rest;

import jdk.nashorn.internal.objects.annotations.Getter;
import ru.softwerke.practice.app2019.model.Color;
import ru.softwerke.practice.app2019.model.Customer;
import ru.softwerke.practice.app2019.service.DataService;
import ru.softwerke.practice.app2019.service.CustomerDataService;
import ru.softwerke.practice.app2019.memory.DeviceFilter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Path("customer")
public class CustomerRestController {
    private DataService<Customer> customerDataService;

    @Inject
    public CustomerRestController(DataService<Customer> customerDataService){
        this.customerDataService = customerDataService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers(){
        return customerDataService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer createCustomer(Customer customer) {
        UUID customerId = customerDataService.put(customer);
        customer.setId(customerId);
        return customer;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") UUID id) {
        return customerDataService.getItemById(id);
    }
}