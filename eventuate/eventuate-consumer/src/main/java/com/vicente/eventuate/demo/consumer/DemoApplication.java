package com.vicente.eventuate.demo.consumer;
import com.vicente.eventuate.demo.consumer.eventListener.ApplicationSubscriber;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import io.eventuate.javaclient.driver.*;

@SpringBootApplication
@EnableEventHandlers
@EntityScan("com.vicente.eventuate.demo.consumer")
@Import({ EventuateDriverConfiguration.class})
@ComponentScan({ "com.vicente.eventuate.demo.consumer","com.vicente.eventuate.common"})
public class DemoApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run( DemoApplication.class, args );
    }

    @Bean
    public ApplicationSubscriber ApplicationQueryWorkflow() {
        return new ApplicationSubscriber();
    }

}
