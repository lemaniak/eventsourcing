package com.vicente.eventuate.common.events;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity="com.vicente.eventuate.demo.aggregates.ApplicationAggregate")
public interface ApplicationEvent extends Event
{

}
