package ru.softwerke.practice.app2019.service;

import ru.softwerke.practice.app2019.model.Customer;
import ru.softwerke.practice.app2019.memory.DeviceFilter;
import ru.softwerke.practice.app2019.memory.Memory;
import ru.softwerke.practice.app2019.memory.SomeMemory;

import java.util.List;
import java.util.UUID;

public class CustomerDataService implements DataService<Customer> {
    private SomeMemory<Customer> memory;

    public CustomerDataService(SomeMemory<Customer> memory){
        this.memory = memory;
    }

    @Override
    public UUID put(Customer customer) {
        return memory.save(customer);
    }

    @Override
    public Customer getItemById(UUID id) {
        return memory.get(id);
    }

    @Override
    public List<Customer> getAll(DeviceFilter filter) {
        return memory.getAll(filter);
    }
}
