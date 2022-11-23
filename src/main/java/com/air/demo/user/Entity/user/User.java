package com.air.demo.user.Entity.user;
import com.air.demo.masterData.entites.MasterCountry;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private int gender;
    // 1 = male
    // 2 = female
    // 3 = other
    // 0 = need to provide

    @Column(name = "dob")
    private String dob;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "phone_code_id")
    private MasterCountry phoneCode;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status")
    private int status;
    //inactive = 0
    //active   = 1
    //deleted  = 2

    @Column(name = "journey_status")
    private int journeyStatus;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private MasterCountry country;


    @Column(name = "is_email_validated")
    private Boolean isEmailValidated;

    @Column(name = "is_phone_validated")
    private Boolean isPhoneValidated;

    @ManyToOne
    @JoinColumn( name ="role_id")
    private Role role;



}
