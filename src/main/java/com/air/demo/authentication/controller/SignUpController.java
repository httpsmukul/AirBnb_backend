package com.air.demo.authentication.controller;


import com.air.demo.authentication.service.SignUpService;
import com.air.demo.utilityDto.requestDto.SendOtpReqDto;
import com.air.demo.utilityDto.requestDto.SignUpReqDto;
import com.air.demo.utilityDto.requestDto.ValidatedOtpReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class SignUpController {


    @Autowired
    SignUpService signUpService;

    @PostMapping("/signup")
    public ResponseDto userSignUp(@RequestBody SignUpReqDto signUpReq){


    return signUpService.userSignUp(signUpReq);
    }


    @PostMapping("/sendOtp")
    @ApiOperation(notes = "<b>signUp</b></br> </br>"
            + "role: 1 = SuperAdmin, 2 = Admin, 3 = host, 4 = customer </br>", value = "sendOtp"
    )
    public ResponseDto sendOtp(@RequestBody SendOtpReqDto signUpReq){

        return signUpService.sendOtp(signUpReq);
    }

    @PostMapping("/validateOtp")
    public ResponseDto validateOtp(@RequestBody ValidatedOtpReqDto validatedOtpReq){

        return signUpService.validateOtp(validatedOtpReq);
    }

}
