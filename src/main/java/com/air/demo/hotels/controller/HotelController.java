package com.air.demo.hotels.controller;


import com.air.demo.hotels.dto.request.AddPropertyDto;
import com.air.demo.hotels.service.HotelService;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add-property")
    public ResponseDto addHotels(AddPropertyDto addPropertyDto){

        return hotelService.addHotels(addPropertyDto);
    }





}
