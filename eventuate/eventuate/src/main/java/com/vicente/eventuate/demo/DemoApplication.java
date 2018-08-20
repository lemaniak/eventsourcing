package com.vicente.eventuate.demo;

import com.vicente.eventuate.demo.aggregates.ApplicationAggregate;
import com.vicente.eventuate.demo.commands.ApplicationCommand;
import com.vicente.eventuate.demo.eventhandlers.ApplicationCompleteSubscriber;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@EnableEventHandlers
@EntityScan("com.vicente.eventuate.demo")
@Import({ EventuateDriverConfiguration.class})
@ComponentScan({ "com.vicente.eventuate.demo","com.vicente.eventuate.common"})
public class DemoApplication
{

    public static void main( String[] args )
    {
        SpringApplication.run( DemoApplication.class, args );
    }


    @Bean
    public AggregateRepository<ApplicationAggregate, ApplicationCommand> aggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(ApplicationAggregate.class, eventStore);
    }

    @Bean
    public ApplicationCompleteSubscriber applicationCompleteSubscriber(){
        return new ApplicationCompleteSubscriber();
    }
}
