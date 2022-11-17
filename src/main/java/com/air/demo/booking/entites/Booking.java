package com.air.demo.booking.entites;

import com.air.demo.hotels.entites.Hotels;
import com.air.demo.user.Entity.User;
import com.air.demo.user.Entity.coustomer.Customer;
import com.air.demo.user.Entity.coustomer.Guest;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customerId;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotels hotel;

    @ManyToOne
    @JoinColumn(name = "customer_profile_id")
    private Customer customerProfileId;

    @ManyToOne
    @JoinColumn(name = "gust_id")
    private Guest gustProfileId;











}
