package com.ascending.hhhEats.service;

import com.ascending.hhhEats.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.io.File;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("Unit")
public class UploadObjectTest {
    @Autowired
    private UploadObject uploadObject;

    @Test
    @Transactional
    public void uploadObjectTest() {
        File f = new File("unittest.txt");
        uploadObject.uploadObject("hhheats", f);
    }
}
