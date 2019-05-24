package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.AuthenticationRequest;
import com.ascending.hhhEats.domain.User;
import com.ascending.hhhEats.extend.exp.NotFoundException;
import com.ascending.hhhEats.extend.security.JwtTokenUtil;
import com.ascending.hhhEats.service.RestaurantService;
import com.ascending.hhhEats.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api/users", "/api/user"}, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //url: /api/users
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList() {
        logger.debug("list users");
        return userService.findAll();
    }

    //url: /api/user/signup POST
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signUpUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public User loginUser(@RequestBody User user) {
////        userService.createUser(user);
//        String encodedPass = encoder.encode(user.getPassword());
//        String storedPass = userService.findByUsername(user.getUsername()).get().getPassword();
//        if (encodedPass.equals(storedPass)) {
//            return user;
//        }
//        logger.info(user.getUsername() + "Has been logged in successfully");
//        logger.info(user.getPassword() + "Has been logged in successfully");
//        return null;
//    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            Authentication notFullyAuthenticated = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );
            final Authentication authentication = authenticationManager.authenticate(notFullyAuthenticated);
            SecurityContextHolder.getContext().setAuthentication(authentication);
//            final UserDetails userDetails = userService.findByUsername(authenticationRequest.getUsername()).get();
//            final String token = jwtTokenUtil.generateToken(userDetails);
//            return ResponseEntity.ok(token);
            try {
                final UserDetails userDetails = userService.findByUsername(authenticationRequest.getUsername()).get();
                final String token = jwtTokenUtil.generateToken(userDetails);
                Map<String, String> res = new HashMap<>();
                res.put("token",token);
                return ResponseEntity.ok(res);
            }
            catch (NotFoundException ex) {
                logger.error("System can't find user by username", ex);
                return ResponseEntity.notFound().build();
            }
//            catch (NotFoundException e) {
//                logger.error("System can't find user by username", e);
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok("login successfully");
        }
        catch (AuthenticationException e) {
            logger.error("System can't find user by email or username", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("authentication");
        }
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
        try {
            Optional<User> user = userService.findByUsername(username);
            return user.get();
        }
        catch (NotFoundException ex) {
            return null;
        }
    }


}
