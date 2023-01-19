package com.air.demo.masterData.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class MasterLanguage {

    @Id
    @Column(name="id")
    private long id;


    @Column(name="title", columnDefinition = " VARCHAR(255) NOT NULL")
    private String title;


    //1= active, 0 = inactive
    @Column(name="status", columnDefinition = " int4 NOT NULL ")
    private int status;
    
    
}
