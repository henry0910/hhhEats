package com.ascending.hhhEats.service;

import com.amazonaws.services.s3.AmazonS3;
import com.ascending.hhhEats.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.io.File;
import java.net.URL;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class StorageServiceTest {
    @Autowired
    private StorageService storageService;
    @Autowired
    private AmazonS3 s3Fake;

    @Test
    @Transactional
    public void uploadObjectTest() {
//        AmazonS3 s3Fake = Mockito.mock(AmazonS3.class);
        File testFile = new File("pom.xml");
        storageService.uploadObject("hhheats", testFile);
        verify(s3Fake, times(1)).putObject(any());
    }

    @Test
    @Transactional
    public void getObjectTest() {
        String bucketName = "123";
        String key = "123.png";
        String url = storageService.getObject(bucketName, key);
        when(url).thenReturn("327464489");
        verify(s3Fake, times(1)).getUrl(anyString(), anyString());
//        String bucketName = "hhheats";
//        String key = "unittest.txt";
//        s3Fake
//        String url = "https://" + bucketName + ".s3.amazonaws.com/" + key;

    }
}
