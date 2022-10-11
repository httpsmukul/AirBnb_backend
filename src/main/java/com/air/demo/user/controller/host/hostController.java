package com.air.demo.user.controller.host;

import com.air.demo.user.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/honor")
public class hostController {


    @Autowired
    HostService honorService;
    @GetMapping("/get")
    public String doSomthing(){

        return honorService.honorIntrest();
    }
}
