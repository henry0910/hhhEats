package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Category;
import com.ascending.hhhEats.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CrudService<Category, Long> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    protected CrudRepository<Category, Long> getCurdRepository() {
        return this.categoryRepository;
    }
}
