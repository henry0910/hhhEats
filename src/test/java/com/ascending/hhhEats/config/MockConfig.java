package com.ascending.hhhEats.config;

import com.amazonaws.services.s3.AmazonS3;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class MockConfig {
    @Bean
    @Profile({"unit"})
    public AmazonS3 getAmazonS3() {
        AmazonS3 s3 = Mockito.mock(AmazonS3.class);
        return s3;
    }
}
