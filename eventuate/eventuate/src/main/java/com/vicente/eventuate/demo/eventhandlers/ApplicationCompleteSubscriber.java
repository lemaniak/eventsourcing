package com.vicente.eventuate.demo.eventhandlers;

import com.vicente.eventuate.common.events.ApplicationCompletedEvent;
import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EventSubscriber(id = "applicationCompleteEventHandler")
public class ApplicationCompleteSubscriber
{
    Logger logger = LoggerFactory.getLogger(ApplicationCompleteSubscriber.class);

    @EventHandlerMethod
    public void create(DispatchedEvent<ApplicationCompletedEvent> ctx) {
        String appId=(ctx.getEvent().getApplicationId());
        System.out.print( appId );
        logger.info( String.format( "EVENT RECEIVED %s",appId ) );

    }
}
