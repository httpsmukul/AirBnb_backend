package com.air.demo.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class AddPropertyDto {

    private Long hostId;

    private String propertyName;

    private PropertyAddressDto propertyAddressDto;

    List<PropertyImageDto> propertyImageDto;

}
