package com.air.demo.utilityDto.responseDto;

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
