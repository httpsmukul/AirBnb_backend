package com.air.demo.hotels.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class HotelAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;
    @OneToOne
   @JoinColumn(name = "hotel_id")
   private Hotels hotels;






}