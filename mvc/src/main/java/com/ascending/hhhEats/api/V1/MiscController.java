package com.ascending.hhhEats.api.V1;

import com.ascending.hhhEats.service.AuthorityService;
import com.ascending.hhhEats.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController("UtilRestV1")
@RequestMapping(value = "/api/misc")
public class MiscController {
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private CategoryService categoryService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value="/picture", method = RequestMethod.POST)
    public Map<String, String> uploadPicture(@RequestParam(value="pic") MultipartFile picture) {
        logger.info("enter the upload picture section!" + picture.getOriginalFilename());
        return new HashMap<>();
    }
}
