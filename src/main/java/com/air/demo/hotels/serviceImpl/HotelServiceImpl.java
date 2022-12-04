package com.air.demo.hotels.serviceImpl;

import com.air.demo.dto.commonDto.IdDto;
import com.air.demo.dto.request.AddPropertyDto;
import com.air.demo.dto.request.PropertyAddressDto;
import com.air.demo.dto.request.PropertyImageDto;
import com.air.demo.hotels.entites.HotelAddress;
import com.air.demo.hotels.entites.HotelImages;
import com.air.demo.hotels.entites.Hotels;
import com.air.demo.hotels.repository.HotelAddressRepository;
import com.air.demo.hotels.repository.HotelImageRepository;
import com.air.demo.hotels.repository.HotelsRepository;
import com.air.demo.hotels.service.HotelService;
import com.air.demo.masterData.Repository.MasterAreaRepository;
import com.air.demo.masterData.Repository.MasterCityRepository;
import com.air.demo.masterData.Repository.MasterCountryRepository;
import com.air.demo.masterData.entites.MasterArea;
import com.air.demo.masterData.entites.MasterCity;
import com.air.demo.masterData.entites.MasterCountry;
import com.air.demo.user.Entity.host.Host;
import com.air.demo.user.repository.HostRepository;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelServiceImpl implements HotelService {


    @Autowired
    HotelAddressRepository hotelAddressRepository;

    @Autowired
    HotelsRepository hotelsRepository;

    @Autowired
    HotelImageRepository hotelImageRepository;

    @Autowired
    MasterCountryRepository masterCountryRepository;

    @Autowired
    MasterCityRepository masterCityRepository;

    @Autowired
    MasterAreaRepository masterAreaRepository;

    @Autowired
    Environment environment;

    @Autowired
    HostRepository hostRepository;



    @Override
    public ResponseDto addHotels(AddPropertyDto propertyDto) {
        hotelsValidation(propertyDto);

        Hotels hotels = new Hotels();
        hotels.setHotelName(propertyDto.getPropertyName());
        HotelAddress hotelAddress = this.saveHotelAddressName(propertyDto.getPropertyAddressDto());
        hotels.setHotelAddress(hotelAddress);
        Host host = getHost(propertyDto.getHostId());
        if(!Objects.isNull(host)){
            hotels.setHost(host);
        }else{
            throw new ServiceException("host not found");
        }
        UUID uuid=UUID.randomUUID();
        hotels.setHotelRegistration(Integer.parseInt(uuid.toString()));
        saveHotelImage(propertyDto.getPropertyImageDto(),hotels);

        hotelsRepository.save(hotels);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData("Property Successfully added");
        responseDto.setMessage("SCUESS");
        responseDto.setStatus(true);
        return responseDto;

    }



    private Hotels savePropertyName(String name){

        Hotels hotels = new Hotels();

        hotels.setHotelName(name);

        return hotels;
    }
    private Host getHost(Long hostId){
        Optional<Host> host = hostRepository.findById(hostId);
        return host.orElse(null);
    }

    private HotelAddress saveHotelAddressName(PropertyAddressDto propertyAddressDto) {

        HotelAddress hotelAddress = new HotelAddress();
        MasterCountry country = masterCountryRepository.findByIdAndStatus(propertyAddressDto.getCountryId(),
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));
         if(!Objects.isNull(country)){
             hotelAddress.setCountry(country);
         }else {
             throw new ServiceException("Country not found");
         }
       MasterCity city = masterCityRepository.findByIdAndStatus(propertyAddressDto.getCityId(),
               Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));
        if(!Objects.isNull(city)){
            hotelAddress.setCity(city);
        }else {
            throw new ServiceException("City not found");
        }

        MasterArea masterArea = masterAreaRepository.findByIdAndStatus(propertyAddressDto.getAreaId(),
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));
        if(!Objects.isNull(masterArea)){
            hotelAddress.setArea(masterArea);
        }else {
            throw new ServiceException("Area not found");
        }

        hotelAddress.setLandMark(propertyAddressDto.getLandMark());


        return hotelAddressRepository.save(hotelAddress);
    }

    private HotelImages saveHotelImage(List<PropertyImageDto> propertyImage, Hotels hotels){

        List<HotelImages> listOfHotelImage = new ArrayList<>();
        for (PropertyImageDto propertyImageDto : propertyImage) {
            HotelImages hotelImages = new HotelImages();
            hotelImages.setHotels(hotels);
            hotelImages.setImage(propertyImageDto.getImage());
            hotelImages.setStatus(Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));
            listOfHotelImage.add(hotelImages);
        }
        hotelImageRepository.saveAll(listOfHotelImage);


        return null;
    }


    private void hotelsValidation(AddPropertyDto propertyDto){

        if(Objects.isNull(propertyDto.getPropertyName())){
            throw new ServiceException("Hotel name should not be null");
        }

        if(Objects.isNull(propertyDto.getPropertyAddressDto())){
            throw new ServiceException("Hotel Address should not be null");
        }

        if(Objects.isNull(propertyDto.getPropertyImageDto())){
            throw new ServiceException("Hotel should not bbe null");
        }

    }


    @Override
    public ResponseDto removeHotels(IdDto idDto) {

        Optional<Hotels> hotels = hotelsRepository.findById(idDto.getId());
        hotels.ifPresent(value -> value.setStatus(Integer.parseInt(Objects.requireNonNull(environment.getProperty("inactive")))));
        hotels.ifPresent(value -> hotelsRepository.save(value));

       ResponseDto responseDto = new ResponseDto();
       responseDto.setData("Hotel Remove Successfully");
       responseDto.setStatus(true);
       responseDto.setMessage("SCUESS");
        return responseDto;
    }

}
