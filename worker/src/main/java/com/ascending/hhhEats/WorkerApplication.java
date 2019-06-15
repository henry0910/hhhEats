package com.ascending.hhhEats;

import com.ascending.hhhEats.service.SQSMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WorkerApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(WorkerApplication.class, args);
//        SQSMessageService messageService = app.getBean(SQSMessageService.class);
//        messageService.receiveMessage();
    }
}