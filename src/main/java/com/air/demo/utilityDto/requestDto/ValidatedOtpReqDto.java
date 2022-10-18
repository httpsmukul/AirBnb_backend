package com.air.demo.utilityDto.requestDto;

import lombok.Data;

@Data
public class ValidatedOtpReqDto {

    private String otpViaValue;

    private String enteredOtp;

    private String phoneCodeId;


}
