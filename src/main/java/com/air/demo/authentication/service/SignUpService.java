package com.air.demo.authentication.service;

import com.air.demo.utilityDto.requestDto.SendOtpReqDto;
import com.air.demo.utilityDto.requestDto.SignUpReqDto;
import com.air.demo.utilityDto.requestDto.ValidatedOtpReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;



public interface SignUpService {

    public ResponseDto sendOtp(SendOtpReqDto signUpReq);

    public ResponseDto validateOtp(ValidatedOtpReqDto validatedOtpReq);

    public ResponseDto userSignUp(SignUpReqDto signUpReq);


}
