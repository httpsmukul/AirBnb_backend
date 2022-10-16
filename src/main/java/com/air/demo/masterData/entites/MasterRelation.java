package com.air.demo.masterData.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MasterRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;


}
