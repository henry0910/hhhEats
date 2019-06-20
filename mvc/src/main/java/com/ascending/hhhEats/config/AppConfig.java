package com.ascending.hhhEats.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;


@Configuration
@ComponentScan(basePackages = "com.ascending.hhhEats",
                excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.ascending.hhhEats.api.*"))
public class AppConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean(name = "shareProperties")
    public PropertiesFactoryBean getShareProperties() {
        logger.debug("I am in the share properties");
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("META-INF/share-runtime.properties"));
        return bean;
    }
    @Bean(name = "AmazonS3")
    @Profile({"dev","test", "prod"})
    public AmazonS3 getAmazonS3bean() {
        String clientRegion = "us-east-1";
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(clientRegion)
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
        return s3;
    }
    @Bean(name = "AmazonSQS")
    @Profile({"dev","test", "prod"})
    public AmazonSQS getAmazonSQS() {
        AmazonSQS client = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return client;
    }
}
