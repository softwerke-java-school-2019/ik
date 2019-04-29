package ru.softwerke.practice.app2019.controller.rest;

import jdk.nashorn.internal.objects.annotations.Getter;
import ru.softwerke.practice.app2019.filter.FilterCreator;
import ru.softwerke.practice.app2019.model.Bill;
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

@Path("bill")
public class BillRestController {
    private Service<Bill> billDataService;

    @Inject
    public BillRestController(Service<Bill> billDataService){
        this.billDataService = billDataService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bill> getBills(@Context UriInfo ui){
    	return billDataService.getAll(FilterCreator.createBillFilter(ui));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Bill createBill(Bill bill) {
        billDataService.put(bill);
        return bill;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bill getBill(@PathParam("id") Integer id) {
        return billDataService.getItemById(id);
    }
}