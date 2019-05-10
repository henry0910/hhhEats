package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Restaurant;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.repository.UserRepository;
import com.ascending.hhhEats.service.RestaurantService;
import com.ascending.hhhEats.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api/users", "/api/user"}, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //url: /api/users
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList() {
        logger.debug("list users");
        return userService.findAll();
    }

    //url: /api/user POST
    @RequestMapping(method = RequestMethod.POST)
    public User signUpUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    //url: /api/user/Id GET
    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public User getUserById(@PathVariable("Id") Long Id) {
        Optional<User> opt = userService.findById(Id);
        return opt.get();
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{Id}/order")
//    public List<Order> getUserOrders(@PathVariable("Id") Long Id) {
//        Optional<User> opt = userService.findById(Id);
//        return opt.get();
//    }

    // url: /api/user/?username = username
    @RequestMapping(method = RequestMethod.GET, params = {"username"})
    public User getUserById(@RequestParam("username") String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.get();
    }


}
