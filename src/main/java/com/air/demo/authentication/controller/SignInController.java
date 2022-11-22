package com.air.demo.authentication.controller;


import com.air.demo.authentication.service.SignInService;
import com.air.demo.utilityDto.requestDto.SendOtpReqDto;
import com.air.demo.utilityDto.requestDto.SignInReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SignInController {

    @Autowired
    private SignInService signInService;


@PostMapping("/login")
    public ResponseDto loginInUser(@RequestBody SignInReqDto signInReqDto){

        return signInService.logInUser(signInReqDto);
    }















}
