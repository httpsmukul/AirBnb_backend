package com.air.demo.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String message;

//    private Map<String, String> indexError;
//    private LocalDateTime localDateTime;

}
