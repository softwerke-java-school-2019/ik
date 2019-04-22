package ru.softwerke.practice.app2019.memory;

import org.glassfish.jersey.internal.util.Producer;
import ru.softwerke.practice.app2019.model.Customer;
import ru.softwerke.practice.app2019.filter.Filter;
import ru.softwerke.practice.app2019.filter.CustomerFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerMemory implements Memory<Customer> {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public UUID save(Customer customer) {
        UUID customerId = UUID.randomUUID();
        customer.setId(customerId);
        customers.add(customer);
        return customer.getId();
    }

    @Override
    public List<Customer> getAll(Filter filter) {
    	//System.out.println("Not supported yet");
    	//return new ArrayList<>();
        return customers.stream().filter(device -> filterCustomer(filter, device)).collect(Collectors.toList());
    }

    @Override
    public Customer get(UUID id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }

    private static boolean filterCustomer(Filter filterGen, Customer customer) {
    	 
    	    	CustomerFilter filter;
    	    	try {
    	    	filter =(CustomerFilter)filterGen;
    	    	}catch(ClassCastException e) {
    	    		return true;
    	    	}
    	        return (isEqual(filter::getBornDate, customer::getBornDate)
    	                && isEqual(filter::getFirstName, customer::getFirstName)
    	                && isEqual(filter::getSecondName, customer::getSecondName)
    	                && isEqual(filter::getThirdName, customer::getThirdName)
    	                
    	                );
    	    }
    private static <T> boolean isEqual(Producer<T> f1, Producer<T> f2) {
    	try {
        T v1 = f1.call();
        if (v1 == null) {
            return true;
        }
        T v2 = f2.call();
        
        return v1.equals(v2);
    	}catch(Throwable e) {
    		e.printStackTrace();
    		return true;
    	}
        
    }
}

