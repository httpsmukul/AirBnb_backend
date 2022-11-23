package com.air.demo.hotels.entites;

import com.air.demo.masterData.entites.MasterArea;
import com.air.demo.masterData.entites.MasterCity;
import com.air.demo.masterData.entites.MasterCountry;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class HotelAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private MasterCountry country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private MasterCity city;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private MasterArea area;

    @Column(name = "land_mark")
    private String landMark;

}