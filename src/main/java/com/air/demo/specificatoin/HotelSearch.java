package com.air.demo.specificatoin;

import com.air.demo.common.utilityDto.responseDto.ResponseDto;
import com.air.demo.hotels.entites.Hotels;
import com.air.demo.hotels.repository.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HotelSearch {

    @Autowired
    HotelsRepository hotelsRepository;

    public  ResponseDto hotelSearch(){
        List<SearchCriteria> criteriaList = new ArrayList<>();
        JpaSpecificationForHotels jpaSpecificationForHotels = new JpaSpecificationForHotels(criteriaList);

        List<Hotels> listOfHotels = hotelsRepository.findAll(jpaSpecificationForHotels);
        ResponseDto responseDto = new ResponseDto();
         responseDto.setData(listOfHotels);
        return responseDto;
    }



}
