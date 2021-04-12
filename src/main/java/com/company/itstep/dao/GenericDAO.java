package com.company.itstep.dao;

public interface GenericDAO<T, ID> {
    void save(T t);

    void update(T t);

    void delete(ID id);

    T getById(ID id);
}
