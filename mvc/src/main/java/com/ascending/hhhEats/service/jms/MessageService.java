package com.ascending.hhhEats.service.jms;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private AmazonSQS sqs;
    private String queueUrl;

    public MessageService(@Autowired AmazonSQS sqs, @Value("${jms.queue.name}") String sqsName) {
        this.sqs = sqs;
        this.queueUrl = getQueueUrl(sqsName);
    }

    public String getQueueUrl(String queueName) {
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        return queueUrl;
    }

    public void sendMessage(String message, Integer delaySec) {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(message)
                .withDelaySeconds(delaySec);
        sqs.sendMessage(send_msg_request);
    }
}
