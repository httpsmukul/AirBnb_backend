package com.air.demo.common.utilityDto.responseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper=false)
public class ResponseDto {

    boolean status;

    Object data;

    String message;

}
