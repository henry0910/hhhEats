package com.ascending.hhhEats.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CrudService<T,ID> {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected abstract CrudRepository<T,ID> getCurdRepository();
    public T save(T entity){
        return this.getCurdRepository().save(entity);
    }
    public Optional<T> findById(ID Id) {
        Optional<T> entity = getCurdRepository().findById(Id);
        return entity;
    }

    public List<T> findAll() {
        Iterable<T> source = getCurdRepository().findAll();
        return Lists.newArrayList(source);
    }
}
