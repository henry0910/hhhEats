package com.ascending.hhhEats.service;

import com.ascending.hhhEats.config.AppConfig;
import com.ascending.hhhEats.domain.Category;
import com.ascending.hhhEats.domain.Courier;
import com.ascending.hhhEats.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    @Transactional
    public void findByIdTest() {
        Category c = new Category("Asian");
        categoryService.save(c);
        Optional<Category> testCategory = categoryService.findById(c.getId());
        assertNotNull(testCategory);
        assertEquals(c.getId(), testCategory.get().getId());
    }
}
