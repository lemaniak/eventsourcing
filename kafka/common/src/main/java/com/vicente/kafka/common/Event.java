package com.vicente.kafka.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;


public class Event
{

    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private String time;
    private EventType eventType;
    private String payload;

    public Event()
    {
    }

    public Event( String id, String time, EventType eventType, String payload )
    {
        this.id = id;
        this.time = time;
        this.eventType = eventType;
        this.payload = payload;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime( String time )
    {
        this.time = time;
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public void setEventType( EventType eventType )
    {
        this.eventType = eventType;
    }

    public String getPayload()
    {
        return payload;
    }

    public void setPayload( String payload )
    {
        this.payload = payload;
    }

    @Override public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
