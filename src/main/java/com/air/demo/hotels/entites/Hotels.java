package com.air.demo.hotels.entites;

import com.air.demo.user.Entity.host.Host;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "address")
    private String address;





























}
