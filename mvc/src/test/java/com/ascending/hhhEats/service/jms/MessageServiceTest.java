package com.ascending.hhhEats.service.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.ascending.hhhEats.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URL;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;
    @Autowired
    private AmazonSQS sqsFake;

    @Value("${jms.queue.name}")
    private String queueName;
    @Test
    public void sendMessageTest() {
        String message = "wohenqiang";

        messageService.sendMessage("xx",5);
//        Mockito.verify(sqsFake, Mockito.times(1)).getQueueUrl(queueName);
        Mockito.verify(sqsFake, Mockito.times(1)).sendMessage(Mockito.any());
    }
}
