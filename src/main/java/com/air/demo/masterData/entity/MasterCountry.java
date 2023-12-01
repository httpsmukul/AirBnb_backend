package com.air.demo.masterData.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class MasterCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="country_code", columnDefinition = " VARCHAR(255) ")
    private String countryCode;

    //1= active, 0 = inactive, 2 = deleted
    @Column(name="status", columnDefinition = " int4 NOT NULL")
    private int status;

    @Column(name="phone_code", columnDefinition = " VARCHAR(100) NOT NULL")
    private String phoneCode;

    @Column(name="title", columnDefinition = " VARCHAR(255) NOT NULL")
    private String title;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}
