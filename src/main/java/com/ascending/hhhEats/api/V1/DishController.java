package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Dish;
import com.ascending.hhhEats.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class DishController {
    @Autowired
    private DishService dishService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public List<Dish> getCourierList() {
        return dishService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public Optional<Dish> getCourierById(@PathVariable("Id") Long Id) {
        return dishService.findById(Id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Dish createNewDish(@RequestBody Dish Dish) {
        dishService.save(Dish);
        return Dish;
    }
}