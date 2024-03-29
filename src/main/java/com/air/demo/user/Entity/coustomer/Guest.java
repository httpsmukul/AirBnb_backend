package com.air.demo.user.Entity.coustomer;

import com.air.demo.masterData.entity.MasterCountry;
import com.air.demo.masterData.entity.MasterRelation;
import com.air.demo.user.Entity.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "guest")
public class Guest {

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

    @ManyToOne
    @JoinColumn(name = "phone_code_id")
    private MasterCountry phoneCodeId;

    @ManyToOne
    @JoinColumn(name = "relation")
    private MasterRelation relation;

    @Column(name = "address")
    private String address;


}
