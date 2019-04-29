package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
@ResponseBody
@RequestMapping(value = {"/api/courier", "/api/couriers"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CourierController {
    @Autowired
    private CourierService courierService;

}
