package org.mf.repository;

import java.util.List;

public interface CRUD<T>{
    List<T> select();
    void create(T t);
    void update(T t);
    void delete(Integer id);
    T getById(Integer id);

}
