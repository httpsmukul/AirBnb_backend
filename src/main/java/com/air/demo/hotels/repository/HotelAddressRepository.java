package com.air.demo.hotels.repository;

import com.air.demo.hotels.entites.HotelAddress;
import com.air.demo.hotels.entites.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelAddressRepository extends JpaRepository<HotelAddress,Long> {

}
