package com.air.demo.hotels.entites;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HotelImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "image",columnDefinition = "text")
    private String image;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotels hotels;
}
