package com.sharingsugar.apigateway.application.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGateWayController {

    @GetMapping("/Hi")
    public void hi(){
        System.out.println("Hi");
    }

}
