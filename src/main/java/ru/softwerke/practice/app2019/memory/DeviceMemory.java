package ru.softwerke.practice.app2019.memory;

import org.glassfish.jersey.internal.util.Producer;
import ru.softwerke.practice.app2019.model.Device;
import ru.softwerke.practice.app2019.filter.Filter;
import ru.softwerke.practice.app2019.filter.DeviceFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.util.UUID;
import java.util.stream.Collectors;

public class DeviceMemory implements Memory<Device> {
    private List<Device> devices = new ArrayList<>();

    @Override
    public Integer save(Device device) {
    	 //UUID deviceId = UUID.randomUUID();
    	//device.setId(deviceId);
    	device.setId(new Random().nextInt(2147483647));
        devices.add(device);
        return device.getId();
    }

    @Override
    public List<Device> getAll(Filter filter) {
        return devices.stream().filter(device -> filterDevice(filter, device)).sorted(((DeviceFilter)filter).getOrder()).collect(Collectors.toList());
        
    }

    @Override
    public Device get(Integer id) {
        return devices.stream().filter(device -> device.getId().equals(id)).findFirst().orElse(null);
    }

    private static boolean filterDevice(Filter filterGen, Device device) {
    	DeviceFilter filter;
    	try {
    	filter =(DeviceFilter)filterGen;
    	}catch(ClassCastException e) {
    		return true;
    	}
        return (isEqual(filter::getSinceDate, device::getManufactureDate)
                && isEqual(filter::getManufacturer, device::getManufacturer)
                && isEqual(filter::getModelName, device::getModelName)
                && isEqual(filter::getDeviceType, device::getDeviceType)
                && isEqual(filter::getColorRGB, device::getColorRGB)
                && isEqual(filter::getPrice, device::getPrice)
                //&& (filter.getPrice() == null || device.getPrice().compareTo(filter.getPrice()) >= 0)
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
