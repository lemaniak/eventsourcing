package com.vicente.eventuate.demo.api;

import com.vicente.eventuate.common.controller.BaseController;
import com.vicente.eventuate.common.model.ResourceWithUrl;
import com.vicente.eventuate.demo.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping( value = "/api/v1/application" )
public class AplicationController extends BaseController
{

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(  method = RequestMethod.POST )
    public CompletableFuture<ResourceWithUrl> createApplication( @RequestBody final String applicationId , HttpServletRequest request){
        return applicationService.save( applicationId ).thenApply( e -> withRequestAttributeContext(request, () -> toResource(e.getAggregate().getApplicationId()) ));
    }

    protected ResourceWithUrl toResource(String appId) {
        ResourceWithUrl<String> result = new ResourceWithUrl<>(appId);
        result.setId(appId);
        result.setUrl("test ok");
        return result;
    }
}
