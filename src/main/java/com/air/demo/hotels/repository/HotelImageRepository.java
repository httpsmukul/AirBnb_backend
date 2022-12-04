package com.air.demo.hotels.repository;

import com.air.demo.hotels.entites.HotelImages;
import com.air.demo.hotels.entites.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImages,Long> {

}
