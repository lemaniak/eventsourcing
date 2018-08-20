package com.vicente.eventuate.common.events;

public class ApplicationCompletedEvent implements ApplicationEvent
{

    private String applicationId;

    public ApplicationCompletedEvent( String applicationId )
    {
        this.applicationId = applicationId;
    }

    public String getApplicationId()
    {
        return applicationId;
    }

    public void setApplicationId( String applicationId )
    {
        this.applicationId = applicationId;
    }
}
