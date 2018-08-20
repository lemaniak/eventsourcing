package com.vicente.consumer.service;

import com.vicente.kafka.common.Event;
import com.vicente.kafka.common.EventType;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApplicationListener
{
    @Value("${application.topic}")
    private String applicationTopic;

    @Value("${application.topic.test}")
    private String applicationTopicTest;

    @Autowired
    private EventProcessService eventProcessService;



    @KafkaListener(topics = "${application.topic}" )
    public void receive(ConsumerRecord record) {
        System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", applicationTopic, record.partition(), record.value()));
        Event received= ( Event ) record.value();
        if(received.getEventType().equals( EventType.COMPLETED ))
        {
            Event event= new Event(received.getId(),LocalDateTime.now().toString(),EventType.NLS_LOAN_CREATED,received.getPayload());
            eventProcessService.publish( event );
        }

    }

    @KafkaListener(topics = "${application.topic.test}" )
    public void recoveryReceive(ConsumerRecord record) {
        System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", applicationTopicTest, record.partition(), record.value()));

    }



}
