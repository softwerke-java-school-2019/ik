package ru.softwerke.practice.app2019.memory;

import org.glassfish.jersey.internal.util.Producer;
import ru.softwerke.practice.app2019.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerMemory implements SomeMemory<Customer> {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public UUID save(Customer customer) {
        UUID customerId = UUID.randomUUID();
        customer.setId(customerId);
        customers.add(customer);
        return customer.getId();
    }

    @Override
    public List<Customer> getAll(DeviceFilter filter) {
    	System.out.println("Not supported yet");
    	return new ArrayList<>();
       // return customers.stream().filter(device -> filterCustomer(filter, device)).collect(Collectors.toList());
    }

    @Override
    public Customer get(UUID id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }

 /*   private static boolean filterCustomer(CustomerFilter filter, Customer customer) {
        return (isEqual(filter::getDate, device::getDate)
                && isEqual(filter::getManufacturer, device::getManufacturer)
                && isEqual(filter::getModel, device::getModel)
                && isEqual(filter::getColor, device::getColor)
                && (filter.getPrice() == null || device.getPrice().compareTo(filter.getPrice()) >= 0)
                );
    }*/

    private static <T> boolean isEqual(Producer<T> f1, Producer<T> f2) {
        T v1 = f1.call();
        T v2 = f2.call();
        if (v1 == null) {
            return true;
        }
        return v1.equals(v2);
    }
}

