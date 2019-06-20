package com.ascending.hhhEats.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class MockConfig {
    @Value("${jms.queue.name}")
    private String queueName;
    @Bean
    @Profile({"unit"})
    public AmazonS3 getAmazonS3() {
        AmazonS3 s3 = Mockito.mock(AmazonS3.class);
        return s3;
    }

    @Bean
    @Profile({"unit"})
    public AmazonSQS getAmazonSQS() {
        AmazonSQS sqs = Mockito.mock(AmazonSQS.class);
        GetQueueUrlResult result = Mockito.mock(GetQueueUrlResult.class);
        Mockito.when(sqs.getQueueUrl(queueName)).thenReturn(result);
        Mockito.when(result.getQueueUrl()).thenReturn("fnrj");
        return sqs;
    }
}
