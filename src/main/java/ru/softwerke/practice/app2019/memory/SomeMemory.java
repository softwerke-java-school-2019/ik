package ru.softwerke.practice.app2019.memory;

import ru.softwerke.practice.app2019.model.Device;

import java.util.List;
import java.util.UUID;

public interface SomeMemory<T> {
     UUID save(T item);

     List<T> getAll(DeviceFilter filter);

     T get(UUID id);
}
