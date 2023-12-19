package com.consumerwork.Consumer.consumer;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class KafkaMessageListener 
{
	Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);
    @KafkaListener(topics = "myGetter-demo",groupId = "myGroup-id")
    public void consume1(String message)
    {
        log.info("consumer consume the events {} ", message);
    }

}
