package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Courier;
import com.ascending.hhhEats.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService extends CrudService<Courier, Long> {

    @Autowired
    private CourierRepository courierRepository;


    @Override
    protected CrudRepository<Courier, Long> getCurdRepository() {
        logger.info("Successfully import");
        return this.courierRepository;
    }




}
