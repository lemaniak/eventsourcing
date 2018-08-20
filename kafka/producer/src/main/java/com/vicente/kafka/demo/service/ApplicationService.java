package com.vicente.kafka.demo.service;

import com.vicente.kafka.common.Event;
import com.vicente.kafka.common.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ApplicationService
{
    private static final Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateRecovery;

    @Value("${application.topic}")
    private String applicationTopic;

    @Value("${application.topic.test}")
    private String applicationTopicTest;

    public void processApplication(String applicationId) {
        Event event= new Event(applicationId,LocalDateTime.now().toString(),EventType.COMPLETED,applicationId);
        kafkaTemplate.send(applicationTopic, event);
        logger.info("sending data='{}' to topic='{}'", event, applicationTopic);
    }

    public void recoveryTest(String applicationId) {
        for(int i=0; i<=100; i++){
            kafkaTemplateRecovery.send(applicationTopicTest, String.format( "Sending message number %s to topic %s ", i, applicationTopicTest));
            logger.info("sending data='{}' to topic='{}'", i, applicationTopic);
            try
            {
                Thread.sleep( 1000 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }

    }
}
