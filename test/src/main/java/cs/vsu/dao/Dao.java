package cs.vsu.dao;

import java.util.List;

public interface Dao<T> {

    T findById(Integer id, Class<T> tClass);
    void save(T t);
    void delete(T t);
    void update(T t);
    List<T> getAll(Class<T> tClass);

}
