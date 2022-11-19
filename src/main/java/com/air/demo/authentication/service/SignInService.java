package com.air.demo.authentication.service;

import com.air.demo.utilityDto.requestDto.SignInReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;

public interface SignInService {

    public ResponseDto logInUser(SignInReqDto signInReqDto);

    public ResponseDto logOutUser(String authorization);
}
