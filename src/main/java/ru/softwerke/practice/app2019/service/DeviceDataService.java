package ru.softwerke.practice.app2019.service;

import ru.softwerke.practice.app2019.model.Device;
import ru.softwerke.practice.app2019.memory.DeviceFilter;
import ru.softwerke.practice.app2019.memory.Memory;
import ru.softwerke.practice.app2019.memory.SomeMemory;

import java.util.List;
import java.util.UUID;

public class DeviceDataService implements DataService<Device> {
    private SomeMemory<Device> memory;

    public DeviceDataService(SomeMemory<Device> memory){
        this.memory = memory;
    }

    @Override
    public UUID put(Device device) {
        return memory.save(device);
    }

    @Override
    public Device getItemById(UUID id) {
        return memory.get(id);
    }

    @Override
    public List<Device> getAll(DeviceFilter filter) {
        return memory.getAll(filter);
    }
}
