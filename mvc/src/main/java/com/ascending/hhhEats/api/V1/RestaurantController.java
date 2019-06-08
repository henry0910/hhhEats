package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Category;
import com.ascending.hhhEats.domain.Courier;
import com.ascending.hhhEats.domain.Restaurant;
import com.ascending.hhhEats.service.CategoryService;
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
    @Autowired
    private CategoryService categoryService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // url: /api/restaurants
    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getRestaurantList() {return restaurantService.findAll();}

    //url: /api/restaurant/Id
    @RequestMapping(method = RequestMethod.GET, value = "{/Id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("Id") Long Id) {return restaurantService.findById(Id);}

    // url: /api/restaurant/category/category_id  POST
    @RequestMapping(value = "category/{category_id}",method = RequestMethod.POST)
    public Restaurant RegisterNewRes(@RequestBody Restaurant restaurant,@PathVariable("category_id") Long categoryId) {
        Optional<Category> c = categoryService.findById(categoryId);
        restaurant.setCategory(c.get());
        restaurantService.save(restaurant);
        return restaurant;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Restaurant createNewRes(@RequestBody Restaurant restaurant) {
        restaurantService.save(restaurant);
        return restaurant;
    }

// url: /api/restaurant?city=shanghai
    @RequestMapping(method = RequestMethod.GET, params = {"city"})
    public List<Restaurant> getRestaurantByUserCity(@RequestParam("city") String city) {
        return restaurantService.findByCity(city);
    }
}
