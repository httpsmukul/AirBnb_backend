package com.air.demo.user.controller.user;

import com.air.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class userController {

    @Autowired
    UserService userService;


    @GetMapping("/user")
    public String aboutUser(){
        return userService.aboutUser();
    }




}
