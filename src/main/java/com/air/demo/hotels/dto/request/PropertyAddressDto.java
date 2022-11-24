package com.air.demo.hotels.dto.request;

import lombok.Data;

@Data
public class PropertyAddressDto {
    private Long countryId;
    private Long CityId;
    private Long areaId;
    private String landMark;
}
