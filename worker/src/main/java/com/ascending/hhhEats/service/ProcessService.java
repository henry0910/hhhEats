package com.ascending.hhhEats.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProcessService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @JmsListener(destination = "hhh_eats_queue_sev")
    public void processMessage(String  msg) throws IOException {
        System.out.println(msg);
    }
}
