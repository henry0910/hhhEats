package com.ascending.hhhEats.service;

import com.ascending.hhhEats.repository.CourierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CourierService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CourierRepository courierRepository;


}
