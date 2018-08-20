package com.vicente.eventuate.demo.consumer.eventListener;

import com.vicente.eventuate.common.events.ApplicationCompletedEvent;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EventSubscriber(id = "applicationEventHandler")
public class ApplicationSubscriber
{
    Logger logger = LoggerFactory.getLogger(ApplicationSubscriber.class);

    @EventHandlerMethod
    public void create(DispatchedEvent<ApplicationCompletedEvent> ctx) {
        String appId=(ctx.getEvent().getApplicationId());
        logger.info( String.format( "EVENT RECEIVED %s",appId ) );

    }
}
