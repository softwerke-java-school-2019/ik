package ru.softwerke.practice.app2019.controller.rest;


import jdk.nashorn.internal.objects.annotations.Getter;
import ru.softwerke.practice.app2019.filter.DeviceFilter;
import ru.softwerke.practice.app2019.filter.FilterCreator;
import ru.softwerke.practice.app2019.model.ColorName;
import ru.softwerke.practice.app2019.model.ColorRGB;
import ru.softwerke.practice.app2019.model.Device;
import ru.softwerke.practice.app2019.model.DeviceTypeName;
import ru.softwerke.practice.app2019.service.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Path("device")
public class DeviceRestController {
    private Service<Device> deviceDataService;

    @Inject
    public DeviceRestController(Service<Device> deviceDataService){
        this.deviceDataService = deviceDataService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getDevices(@Context UriInfo ui){
    	
        return deviceDataService.getAll(FilterCreator.createDeviceFilter(ui));
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Device createDevice(Device device) {
        deviceDataService.put(device);
        return device;
    }
    
    //<pre>-version - don't use
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Device createDeviceForID(@PathParam("id") Integer id,Device device) {
        deviceDataService.put(device);
        return device;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device getDevice(@PathParam("id") Integer id) {
        return deviceDataService.getItemById(id);
    }
}