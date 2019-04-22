package ru.softwerke.practice.app2019.controller.rest;


import jdk.nashorn.internal.objects.annotations.Getter;
import ru.softwerke.practice.app2019.filter.DeviceFilter;
import ru.softwerke.practice.app2019.model.Color;
import ru.softwerke.practice.app2019.model.Device;
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
    	DeviceFilter filter=DeviceFilter.DF_EMPTY;
    	for (String key : ui.getQueryParameters().keySet()) {
    		//System.out.println(key);
    		//System.out.println(ui.getQueryParameters().getFirst(key));
    		switch (key) {
            case "filterByModel": {
            	String model =ui.getQueryParameters().getFirst(key);
            	filter=filter.withModel(model);
    			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withModel(model));
                break;
            }
            case "filterByPrice": {//Works not properly so far
            	BigDecimal price =new BigDecimal(ui.getQueryParameters().getFirst(key));
            	filter=filter.withPrice(price);
    			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withPrice(price));
                break;
            }
            case "filterByColor": {
            	Color color =Color.getColor(ui.getQueryParameters().getFirst(key));
            	filter=filter.withColor(color);
                break;
            }
            case "filterByManufacturer": {
            	String manufacturer =ui.getQueryParameters().getFirst(key);
            	filter=filter.withManufacturer(manufacturer);
    			break;
            }

            default: {
                
                break;
            }
        }    	    		
    	}
    		//System.out.println("Hey!");
        return deviceDataService.getAll(filter);
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Device createDevice(Device device) {
        deviceDataService.put(device);
        return device;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device getDevice(@PathParam("id") UUID id) {
        return deviceDataService.getItemById(id);
    }
}