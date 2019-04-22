package ru.softwerke.practice.app2019.service;


import ru.softwerke.practice.app2019.memory.Memory;
import ru.softwerke.practice.app2019.filter.Filter;
import ru.softwerke.practice.app2019.model.Model;
import java.util.List;
import java.util.UUID;

public class DataService<T extends Model> implements Service<T> {
    private Memory<T> memory;

    public DataService(Memory<T> memory){
        this.memory = memory;
    }

    @Override
    public UUID put(T model) {
        return memory.save(model);
    }

    @Override
    public T getItemById(UUID id) {
        return memory.get(id);
    }

    @Override
    public List<T> getAll(Filter filter) {
        return memory.getAll(filter);
    }
}
