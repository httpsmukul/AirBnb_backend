package com.air.demo.hotels.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class AddPropertyDto {

    private String propertyName;

    private PropertyAddressDto propertyAddressDto;
    List<PropertyImageDto> propertyImageDto;

}
