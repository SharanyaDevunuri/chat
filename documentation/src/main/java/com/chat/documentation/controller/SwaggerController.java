package com.chat.documentation.controller;


import com.chat.documentation.config.ServiceDefinationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
    @Autowired
    private ServiceDefinationContext definitionContext;

    @GetMapping("/service/{servicename}")
    public String getServiceDefinition(@PathVariable("servicename") String serviceName){

        return definitionContext.getSwaggerDefinition(serviceName);

    }
}
