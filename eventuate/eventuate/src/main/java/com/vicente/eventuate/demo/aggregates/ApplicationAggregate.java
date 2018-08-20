package com.vicente.eventuate.demo.aggregates;

import com.vicente.eventuate.common.events.ApplicationCompletedEvent;
import com.vicente.eventuate.demo.commands.ApplicationCommand;
import com.vicente.eventuate.demo.commands.CreateApplicationCommand;
import com.vicente.eventuate.demo.eventhandlers.ApplicationCompleteSubscriber;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class ApplicationAggregate  extends ReflectiveMutableCommandProcessingAggregate<ApplicationAggregate, ApplicationCommand>
{
    Logger logger = LoggerFactory.getLogger(ApplicationAggregate.class);
    private String applicationId;
    private boolean deleted;

    public List<Event> process(CreateApplicationCommand cmd) {
        if (this.deleted) {
            return Collections.emptyList();
        }
        return EventUtil.events(new ApplicationCompletedEvent(cmd.getApplicationId()));
    }

    public void apply(ApplicationCompletedEvent event) {
        this.applicationId = event.getApplicationId();
        System.out.print( applicationId );
        logger.info( String.format( "EVENT ApplicationCompletedEvent RECEIVED %s",applicationId ) );
    }

    public String getApplicationId()
    {
        return applicationId;
    }
}
