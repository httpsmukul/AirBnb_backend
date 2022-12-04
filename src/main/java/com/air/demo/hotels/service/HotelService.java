package com.air.demo.hotels.service;

import com.air.demo.dto.commonDto.IdDto;
import com.air.demo.dto.request.AddPropertyDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;

public interface HotelService {

     ResponseDto addHotels(AddPropertyDto addPropertyDto);
     ResponseDto removeHotels(IdDto idDto);
}
