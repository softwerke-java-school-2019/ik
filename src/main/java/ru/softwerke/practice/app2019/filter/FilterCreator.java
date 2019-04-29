package ru.softwerke.practice.app2019.filter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;

import ru.softwerke.practice.app2019.model.Bill;
import ru.softwerke.practice.app2019.model.ColorRGB;
import ru.softwerke.practice.app2019.model.Customer;
import ru.softwerke.practice.app2019.model.Device;
import ru.softwerke.practice.app2019.model.DeviceTypeName;

public class FilterCreator {
	
public static DeviceFilter createDeviceFilter(@Context UriInfo ui) {
	DeviceFilter filter=new DeviceFilter();
	for (String key : ui.getQueryParameters().keySet()) {
		//System.out.println(key);
		//System.out.println(ui.getQueryParameters().getFirst(key));
		switch (key) {
        case "model": {
        	String model =ui.getQueryParameters().getFirst(key);
        	filter=filter.withModelName(model);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withModel(model));
            break;
        }
        case "deviceType": {
        	DeviceTypeName deviceType =new DeviceTypeName(ui.getQueryParameters().getFirst(key));
        	filter=filter.withDeviceType(deviceType);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withModel(model));
            break;
        }
        case "price": {//Works not properly so far
        	Integer price =new Integer(ui.getQueryParameters().getFirst(key));
        	filter=filter.withPrice(price);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withPrice(price));
            break;
        }
        case "colorName": {
        	ColorRGB color =new ColorRGB(ui.getQueryParameters().getFirst(key));
        	filter=filter.withColorRGB(color);
            break;
        }
        case "manufacturer": {
        	String manufacturer =ui.getQueryParameters().getFirst(key);
        	filter=filter.withManufacturer(manufacturer);
			break;
        }
        case "manufactureDate": {
        	LocalDate manufactureDate =LocalDate.parse(ui.getQueryParameters().getFirst(key), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        	filter=filter.withSinceDate(manufactureDate);
			break;
        }
        case "orderBy":{
        filter=filter.withOrder(createDeviceOrder(ui.getQueryParameters().getFirst(key)));
        //System.out.println("Hey1");
        break;
        }

        default: {
            
            break;
        }
    } 
	
}
	return filter;
}

public static CustomerFilter createCustomerFilter(@Context UriInfo ui) {
	CustomerFilter filter = new CustomerFilter();
	for (String key : ui.getQueryParameters().keySet()) {
		//System.out.println(key);
		//System.out.println(ui.getQueryParameters().getFirst(key));
		switch (key) {
        case "firstName": {
        	String name =ui.getQueryParameters().getFirst(key);
        	filter=filter.withFirstName(name);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withModel(model));
            break;
        }
        case "middleName": {
        	String name =ui.getQueryParameters().getFirst(key);
        	filter=filter.withMiddleName(name);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withModel(model));
            break;
        }
        case "lastName": {//Works not properly so far
        	String name =ui.getQueryParameters().getFirst(key);
        	filter=filter.withLastName(name);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withPrice(price));
            break;
        }
        case "birthdate": {
        	LocalDate birthdate =LocalDate.parse(ui.getQueryParameters().getFirst(key), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        	filter=filter.withBirthDate(birthdate);
			break;
        }
        case "orderBy":{
        filter=filter.withOrder(createCustomerOrder(ui.getQueryParameters().getFirst(key)));
        //System.out.println("Hey1");
        break;
        }

        default: {
            
            break;
        }
    } 
	
}
	return filter;
}

private static Comparator<Device> createDeviceOrder(String str){
	boolean reverse = StringUtils.startsWith(str, "-");
    String strFormed = reverse ? StringUtils.substring(str, 1) : str;
    Comparator<Device> comparator=Comparator.comparing(Device::getId);
	switch (strFormed) {
    case "modelName": {
    	comparator=Comparator.comparing(Device::getModelName);
    	break;
    }
    case "deviceType": {
    	comparator= Comparator.comparing(Device::getDeviceType, (s1, s2) -> {
            return s2.compareTo(s1);
        });
    	break;
    }
    case "price": {//Works not properly so far
    	//System.out.println("Hey!");
    	comparator= Comparator.comparing(Device::getPrice);
    	break;
    }
    case "colorName": {
    	comparator= Comparator.comparing(Device::getColorName, (s1, s2) -> {
            return s2.compareTo(s1);
        });
    	break;
    }
    case "colorRGB": {
    	comparator=Comparator.comparing(Device::getColorRGB, (s1, s2) -> {
            return s2.compareTo(s1);
        });
    	break;
    }
    case "Manufacturer": {
    	comparator=Comparator.comparing(Device::getManufacturer);
    	break;
    }
    case "manufactureDate": {
    	comparator=Comparator.comparing(Device::getManufactureDate);
    	break;
    }
	}
	
	return reverse?comparator.reversed():comparator;
}




public static BillFilter createBillFilter(@Context UriInfo ui) {
	BillFilter filter = new BillFilter();
	for (String key : ui.getQueryParameters().keySet()) {
		//System.out.println(key);
		//System.out.println(ui.getQueryParameters().getFirst(key));
		switch (key) {
        case "customerId": {
        	Integer id =new Integer(ui.getQueryParameters().getFirst(key));
        	filter=filter.withCustomerId(id);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withModel(model));
            break;
        }
        case "totalPrice": {
        	Integer price =new Integer(ui.getQueryParameters().getFirst(key));
        	filter=filter.withTotalPrice(price);
			//return deviceDataService.getAll(DeviceFilter.DF_EMPTY.withModel(model));
            break;
        }
        case "purchaseDateTime": {
        	LocalDateTime purchaseDateTime =LocalDateTime.parse(ui.getQueryParameters().getFirst(key), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        	filter=filter.withPurchaseDateTime(purchaseDateTime);
			break;
        }
        case "orderBy":{
        filter=filter.withOrder(createBillOrder(ui.getQueryParameters().getFirst(key)));
        //System.out.println("Hey1");
        break;
        }

        default: {
            
            break;
        }
    } 
	
}
	return filter;
}







private static Comparator<Customer> createCustomerOrder(String str){
	boolean reverse = StringUtils.startsWith(str, "-");
    String strFormed = reverse ? StringUtils.substring(str, 1) : str;
    Comparator<Customer> comparator=Comparator.comparing(Customer::getId);
	switch (strFormed) {
    case "firstName": {
    	comparator=Comparator.comparing(Customer::getFirstName);
    	break;
    }
    
    case "middleName": {
    	comparator=Comparator.comparing(Customer::getMiddleName);
    	break;
    }
    case "lastName": {
    	comparator=Comparator.comparing(Customer::getLastName);
    	break;
    }
    case "birthdate": {
    	comparator=Comparator.comparing(Customer::getBirthDate);
    	break;
    }
	}
	
	return reverse?comparator.reversed():comparator;
}


private static Comparator<Bill> createBillOrder(String str){
	boolean reverse = StringUtils.startsWith(str, "-");
    String strFormed = reverse ? StringUtils.substring(str, 1) : str;
    Comparator<Bill> comparator=Comparator.comparing(Bill::getId);
	switch (strFormed) {
    case "customerId": {
    	comparator=Comparator.comparing(Bill::getCustomerId);
    	break;
    }
    
    case "totalPrice": {
    	comparator=Comparator.comparing(Bill::getTotalPrice);
    	break;
    }
    case "purchaseDateTime": {
    	comparator=Comparator.comparing(Bill::getPurchaseDateTime);
    	break;
    }
    
	}
	
	return reverse?comparator.reversed():comparator;
}




}
