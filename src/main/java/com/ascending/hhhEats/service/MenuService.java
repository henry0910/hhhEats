package com.ascending.hhhEats.service;

import com.ascending.hhhEats.domain.Menu;
import com.ascending.hhhEats.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends CrudService<Menu, Long> {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    protected CrudRepository<Menu, Long> getCurdRepository() {
        return this.menuRepository;
    }
}
