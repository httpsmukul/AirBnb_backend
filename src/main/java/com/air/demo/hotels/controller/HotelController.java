package com.air.demo.hotels.controller;


import com.air.demo.dto.commonDto.IdDto;
import com.air.demo.dto.request.AddPropertyDto;
import com.air.demo.hotels.repository.HotelsRepository;
import com.air.demo.hotels.service.HotelService;
import com.air.demo.common.utilityDto.responseDto.ResponseDto;
import com.air.demo.specificatoin.HotelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelSearch hotelSearch;

    @Autowired
    private HotelsRepository hotelsRepository;

    @PostMapping("/add-property")
    public ResponseDto addHotels(AddPropertyDto addPropertyDto){

        return hotelService.addHotels(addPropertyDto);
    }

    @PostMapping("/remove-property")
    public ResponseDto removeProperty(IdDto idDto){

        return hotelService.removeHotels(idDto);
    }


    @GetMapping("/searchHotels")
    public ResponseDto getHotels(){

        return hotelSearch.hotelSearch();
    }






}
