package com.air.demo.utilityDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper=false)
public class ResponseDto {

    private boolean status;

    private Objects data;

    private String message;

}
