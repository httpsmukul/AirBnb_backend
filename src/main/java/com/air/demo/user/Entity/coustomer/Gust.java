package com.air.demo.user.Entity.coustomer;

import com.air.demo.masterData.entites.MasterCountry;
import com.air.demo.masterData.entites.MasterRelation;
import com.air.demo.user.Entity.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Gust {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name  = "customer_id")
    private User customer;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "phone_code_id")
    private MasterCountry phoneCodeId;

    @ManyToOne
    @JoinColumn(name = "relation")
    private MasterRelation relation;

    @Column(name = "address")
    private String address;









}
