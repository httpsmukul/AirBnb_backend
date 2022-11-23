package com.air.demo.hotels.controller;


import com.air.demo.utilityDto.responseDto.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @PostMapping("/add-property")
    public ResponseDto addHotels(){



        return null;
    }





}
