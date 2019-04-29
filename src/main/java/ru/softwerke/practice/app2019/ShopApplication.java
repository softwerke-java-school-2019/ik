package ru.softwerke.practice.app2019;

import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import ru.softwerke.practice.app2019.service.Service;
import ru.softwerke.practice.app2019.service.DataService;
import ru.softwerke.practice.app2019.memory.Memory;
import ru.softwerke.practice.app2019.memory.BillMemory;
import ru.softwerke.practice.app2019.memory.CustomerMemory;
import ru.softwerke.practice.app2019.memory.DeviceMemory;
import ru.softwerke.practice.app2019.model.Bill;
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
                Memory<Device> deviceMemory = new DeviceMemory();
                Memory<Customer> customerMemory = new CustomerMemory();
                Memory<Bill> billMemory = new BillMemory();

                /*bind(memory).to(new TypeLiteral<Memory<Device>>() {
                });
                bind(customermemory).to(new TypeLiteral<Memory<Customer>>() {
                });*/
                bind(deviceDataService(deviceMemory)).to(new TypeLiteral<Service<Device>>() {
                });
                bind(customerDataService(customerMemory)).to(new TypeLiteral<Service<Customer>>() {
                });
                bind(billDataService(billMemory)).to(new TypeLiteral<Service<Bill>>() {
                });

            }
        });

        
    }

    private Service<Device> deviceDataService(Memory<Device> memory) {
        return new DataService<Device>(memory);
    }
    private Service<Customer> customerDataService(Memory<Customer> memory) {
        return new DataService<Customer>(memory);
    }
    private Service<Bill> billDataService(Memory<Bill> memory) {
        return new DataService<Bill>(memory);
    }
    
}