package ru.softwerke.practice.app2019.memory;

import org.glassfish.jersey.internal.util.Producer;
import ru.softwerke.practice.app2019.model.Bill;
import ru.softwerke.practice.app2019.filter.BillFilter;
import ru.softwerke.practice.app2019.filter.DeviceFilter;
import ru.softwerke.practice.app2019.filter.Filter;
//import ru.softwerke.practice.app2019.filter.BillFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.util.UUID;
import java.util.stream.Collectors;

public class BillMemory implements Memory<Bill> {
    private List<Bill> bills = new ArrayList<>();

    @Override
    public Integer save(Bill bill) {
    	 //UUID BillId = UUID.randomUUID();
         //Bill.setId(BillId);
    	bill.setId(new Random().nextInt(2147483647));
        bills.add(bill);
        return bill.getId();
    }

    @Override
    public List<Bill> getAll(Filter filter) {
    	//System.out.println("Not supported yet");
    	//return new ArrayList<>();
        return bills.stream().filter(bill -> filterBill(filter, bill)).sorted(((BillFilter)filter).getOrder()).collect(Collectors.toList());
    }

    @Override
    public Bill get(Integer id) {
        return bills.stream().filter(Bill -> Bill.getId().equals(id)).findFirst().orElse(null);
    }

    private static boolean filterBill(Filter filterGen, Bill bill) {
    	BillFilter filter;
    	try {
    	filter =(BillFilter)filterGen;
    	}catch(ClassCastException e) {
    		return true;
    	}
        return (isEqual(filter::getPurchaseDateTime, bill::getPurchaseDateTime)
                && isEqual(filter::getCustomerId, bill::getCustomerId)
                && isEqual(filter::getTotalPrice, bill::getTotalPrice)
                
                //&& (filter.getPrice() == null || bill.getPrice().compareTo(filter.getPrice()) >= 0)
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

