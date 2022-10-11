package com.air.demo.hotals.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Hotals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    
}
