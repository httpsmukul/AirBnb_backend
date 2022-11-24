package com.air.demo.hotels.serviceImpl;

import com.air.demo.hotels.dto.request.AddPropertyDto;
import com.air.demo.hotels.service.HotelService;
import com.air.demo.utilityDto.responseDto.ResponseDto;

public class HotelServiceImpl implements HotelService {



    @Override
    public ResponseDto addHotels(AddPropertyDto propertyDto) {
        hotelsValidation(propertyDto);











        return null;

    }

    private void hotelsValidation(AddPropertyDto propertyDto){




    }

}
