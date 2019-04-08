package ru.softwerke.practice.app2019.controller.rest;

import jdk.nashorn.internal.objects.annotations.Getter;
import ru.softwerke.practice.app2019.model.Color;
import ru.softwerke.practice.app2019.model.Device;
import ru.softwerke.practice.app2019.service.DataService;
import ru.softwerke.practice.app2019.service.DeviceDataService;
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

@Path("device")
public class DeviceRestController {
    private DataService<Device> deviceDataService;

    @Inject
    public DeviceRestController(DataService<Device> deviceDataService){
        this.deviceDataService = deviceDataService;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getDevices(){
        return deviceDataService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Device createDevice(Device device) {
        UUID deviceId = deviceDataService.put(device);
        device.setId(deviceId);
        return device;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device getDevice(@PathParam("id") UUID id) {
        return deviceDataService.getItemById(id);
    }
}