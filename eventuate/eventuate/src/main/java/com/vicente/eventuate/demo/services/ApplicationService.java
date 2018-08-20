package com.vicente.eventuate.demo.services;

import com.vicente.eventuate.demo.aggregates.ApplicationAggregate;
import com.vicente.eventuate.demo.commands.ApplicationCommand;
import com.vicente.eventuate.demo.commands.CreateApplicationCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ApplicationService
{

    private final AggregateRepository<ApplicationAggregate,ApplicationCommand> applicationRepository;

    public ApplicationService( AggregateRepository<ApplicationAggregate, ApplicationCommand> applicationRepository )
    {
        this.applicationRepository = applicationRepository;
    }


    public CompletableFuture<EntityWithIdAndVersion<ApplicationAggregate>> save(String applicationId){
        return applicationRepository.save( new CreateApplicationCommand( applicationId ) );
    }
}
