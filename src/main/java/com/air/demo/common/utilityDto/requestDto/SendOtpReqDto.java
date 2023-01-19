package com.air.demo.common.utilityDto.requestDto;

import lombok.Data;

@Data
public class SendOtpReqDto {

    private String otpViaValue;

    private Long phoneCodeId;

    private int roleId;

}
