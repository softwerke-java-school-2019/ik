package ru.softwerke.practice.app2019.service;


import ru.softwerke.practice.app2019.filter.Filter;
import ru.softwerke.practice.app2019.model.Model;

import java.util.List;
import java.util.UUID;

public interface Service<T extends Model> {
	 UUID put(T item);

	 T getItemById(UUID id);

	 List<T> getAll(Filter filter);

    default  List<T> getAll(){
        return getAll(Filter.EMPTY);
    }
}
