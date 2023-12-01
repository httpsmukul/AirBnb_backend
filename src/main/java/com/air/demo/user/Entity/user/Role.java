package com.air.demo.user.Entity.user;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 1=ROLE_ADMIN, 2=ROLE_SUBADMIN, 3=ROLE_ADVISOR, 4=ROLE_CLIENT
    @Column(name="role_title",nullable = false,columnDefinition = "VARCHAR(255)")
    private String title;

    //1= active, 0 = inactive
    @Column(name="role_status", columnDefinition = " int4 NOT NULL default '1'")
    private int status;


}
