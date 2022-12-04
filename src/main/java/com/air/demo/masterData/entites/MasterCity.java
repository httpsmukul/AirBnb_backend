package com.air.demo.masterData.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class MasterCity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "country_id")
    private MasterCountry country;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "status")
    private  int status;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
