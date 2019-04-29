package ru.softwerke.practice.app2019.memory;


import ru.softwerke.practice.app2019.model.Model;
import ru.softwerke.practice.app2019.filter.Filter;
import java.util.List;
//import java.util.UUID;

public interface Memory<T extends Model> {
     Integer save(T item);

     List<T> getAll(Filter filter);

     T get(Integer id);
}
