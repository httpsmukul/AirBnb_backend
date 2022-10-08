package com.example.demo.user.controller;

import com.example.demo.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")

public class customerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/get")
    public String doSomthing(){

        return customerService.aboutCustomer();
    }

}
