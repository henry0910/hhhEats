package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Dish;
import com.ascending.hhhEats.service.DishService;
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
@RequestMapping(value = {"/api/dishes", "/api/dish"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
    @Autowired
    private DishService dishService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // url: /api/dishes GET
    @RequestMapping(method = RequestMethod.GET)
    public List<Dish> getCourierList() {
        return dishService.findAll();
    }

    // url: /api/dish/Id GET
    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public Optional<Dish> getCourierById(@PathVariable("Id") Long Id) {
        return dishService.findById(Id);
    }

    // url: /api/dish POST
    @RequestMapping(method = RequestMethod.POST)
    public Dish createNewDish(@RequestBody Dish Dish) {
        dishService.save(Dish);
        return Dish;
    }
}
