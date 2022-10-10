package com.example.demo.user.host;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class HostProperity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    @Column(name = "property_name")
    private String name;

    @Column(name = "min_price")
    private float minPrice;

    @Column(name = "max_price")
    private float maxPrice;

    @Column(name = "image_name")
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private ProperityImages image;

    @Column(name = "address")
    private String address;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status")
    private int status;





}
