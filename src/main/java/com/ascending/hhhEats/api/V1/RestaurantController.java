package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Courier;
import com.ascending.hhhEats.domain.Restaurant;
import com.ascending.hhhEats.service.RestaurantService;
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
@RequestMapping(value = {"/api/restaurants","/api/restaurant"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // url: /api/restaurants
    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getRestaurantList() {return restaurantService.findAll();}

    //url: /api/restaurant/Id
    @RequestMapping(method = RequestMethod.GET, value = "{/Id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("Id") Long Id) {return restaurantService.findById(Id);}

    // url: /api/restaurant  POST
    @RequestMapping(method = RequestMethod.POST)
    public Restaurant RegisterNewRes(@RequestBody Restaurant restaurant) {
        restaurantService.save(restaurant);
        return restaurant;
    }
}
