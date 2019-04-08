package ru.softwerke.practice.app2019.service;

import ru.softwerke.practice.app2019.model.Device;
import ru.softwerke.practice.app2019.memory.DeviceFilter;

import java.util.List;
import java.util.UUID;

public interface DataService<T> {
    UUID put(T item);

    T getItemById(UUID id);

    List<T> getAll(DeviceFilter filter);

    default List<T> getAll(){
        return getAll(DeviceFilter.EMPTY);
    }
}
