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

import static junit.framework.TestCase.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("Unit")
public class StorageServiceTest {
    @Autowired
    private StorageService storageService;

    @Test
    @Transactional
    public void uploadObjectTest() {
        File f = new File("unittest.txt");
        storageService.uploadObject("hhheats", f);
    }

    @Test
    @Transactional
    public void getObjectTest() {
        String bucketName = "hhheats";
        String key = "unittest.txt";
        String result = storageService.getObject(bucketName, key);
        String url = "https://" + bucketName + ".s3.amazonaws.com/" + key;
        assertEquals(result, url);
    }
}
