package com.vicente.kafka.demo.api;

import com.vicente.kafka.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "api/docusign" )
public class DocusignController
{

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping( value = "/{applicationId}", method = RequestMethod.POST )
    public ResponseEntity<String> save( @PathVariable String applicationId )
    {
        applicationService.processApplication( applicationId );
        return new ResponseEntity<String>( "Sucess", HttpStatus.OK );
    }

    @RequestMapping( value = "recoveryTest/{applicationId}", method = RequestMethod.POST )
    public ResponseEntity<String> recoveryTest( @PathVariable String applicationId )
    {
        applicationService.recoveryTest( applicationId );
        return new ResponseEntity<String>( "Sucess", HttpStatus.OK );
    }
}
