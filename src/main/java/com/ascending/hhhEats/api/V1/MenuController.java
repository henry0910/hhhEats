package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Menu;
import com.ascending.hhhEats.service.MenuService;
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
@RequestMapping(value = {"/api/menus", "/api/menu"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {
    @Autowired
    private MenuService menuService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public List<Menu> getCourierList() {
        return menuService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public Optional<Menu> getCourierById(@PathVariable("Id") Long Id) {
        return menuService.findById(Id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Menu createNewMenu(@RequestBody Menu Menu) {
        menuService.save(Menu);
        return Menu;
    }
}
