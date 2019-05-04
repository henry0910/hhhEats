package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Courier;
import com.ascending.hhhEats.service.CourierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/courier", "/api/couriers"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CourierController {

    @Autowired
    private CourierService courierService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //url: /api/courier
    @RequestMapping(method = RequestMethod.GET)
    public List<Courier> getCourierList() {
        return courierService.findAll();
    }

    //url: /api/courier/Id
    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public Optional<Courier> getCourierById(@PathVariable("Id") Long Id) {
        return courierService.findById(Id);
    }

    //url: /api/courier/ POST
    @RequestMapping(method = RequestMethod.POST)
    public Courier createNewOrder(@RequestBody Courier courier) {
        courierService.save(courier);
        return courier;
    }

}
