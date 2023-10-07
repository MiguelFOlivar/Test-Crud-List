package org.mf.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> implements FullRepository<T>{
    protected List<T> dataSource;
    public AbstractRepository() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> select() {
        return this.dataSource;
    }

    @Override
    public void create(T t) {
        this.dataSource.add(t);
    }

    @Override
    public abstract void update(T t);

    @Override
    public abstract void delete(Integer id);

    @Override
    public abstract T getById(Integer id);

    @Override
    public abstract List<T> orderBy(String campo, Direction direction);
}
