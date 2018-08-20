package com.vicente.consumer.service;

import com.vicente.kafka.common.Event;
import com.vicente.kafka.common.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProcessService
{
    private static final Logger logger = LoggerFactory.getLogger(EventProcessService.class);

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    @Value("${application.topic}")
    private String applicationTopic;

    public void publish(Event event) {
        kafkaTemplate.send(applicationTopic, event);
        logger.info("sending data='{}' to topic='{}'", event, applicationTopic);
    }
}
