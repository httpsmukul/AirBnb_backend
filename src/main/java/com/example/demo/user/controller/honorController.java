package com.example.demo.user.controller;

import com.example.demo.user.service.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/honor")
public class honorController {


    @Autowired
    HonorService honorService;
    @GetMapping("/get")
    public String doSomthing(){

        return honorService.honorIntrest();
    }
}
