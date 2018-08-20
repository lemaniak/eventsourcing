package com.vicente.eventuate.demo.commands;

public class CreateApplicationCommand implements ApplicationCommand
{

    private String applicationId;

    public CreateApplicationCommand( String applicationId )
    {
        this.applicationId = applicationId;
    }

    public String getApplicationId()
    {
        return applicationId;
    }
}
