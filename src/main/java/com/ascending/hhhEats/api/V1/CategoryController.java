package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.domain.Category;
import com.ascending.hhhEats.service.CategoryService;
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
@RequestMapping(value = {"/api/categories", "/api/category"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //url: /api/courier
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCourierList() {
        return categoryService.findAll();
    }

    //url: /api/courier/Id
    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public Optional<Category> getCourierById(@PathVariable("Id") Long Id) {
        return categoryService.findById(Id);
    }

    //url: /api/courier/ POST
    @RequestMapping(method = RequestMethod.POST)
    public Category createNewOrder(@RequestBody Category category) {
        categoryService.save(category);
        return category;
    }
}
