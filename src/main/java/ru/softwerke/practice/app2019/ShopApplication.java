package ru.softwerke.practice.app2019;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import ru.softwerke.practice.app2019.service.DataService;
import ru.softwerke.practice.app2019.service.DeviceDataService;
import ru.softwerke.practice.app2019.service.CustomerDataService;
import ru.softwerke.practice.app2019.memory.Memory;
import ru.softwerke.practice.app2019.memory.CustomerMemory;
import ru.softwerke.practice.app2019.memory.SomeMemory;
import ru.softwerke.practice.app2019.model.Customer;
import ru.softwerke.practice.app2019.model.Device;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ShopApplication extends ResourceConfig {
    public ShopApplication() {
        packages("ru.softwerke.practice.app2019;com.fasterxml.jackson.jaxrs");

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                SomeMemory<Device> memory = new Memory();
                SomeMemory<Customer> customermemory = new CustomerMemory();

                bind(memory).to(SomeMemory.class);
                bind(customermemory).to(SomeMemory.class);
                bind(deviceDataService(memory)).to(DataService.class);
                bind(customerDataService(customermemory)).to(DataService.class);

            }
        });

        
    }

    private DataService<Device> deviceDataService(SomeMemory<Device> memory) {
        return new DeviceDataService(memory);
    }
    private DataService<Customer> customerDataService(SomeMemory<Customer> customermemory) {
        return new CustomerDataService(customermemory);
    }
}