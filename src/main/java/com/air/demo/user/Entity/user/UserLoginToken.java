package com.air.demo.user.Entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="user_login_token", indexes = {@Index(name = "token_user_id_status_index", columnList ="token,user_id,status"),
        @Index(name = "refresh_token_user_id_status_index", columnList = "refresh_token,user_id,status")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginToken {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="token",columnDefinition = "text", nullable = true)
    private String token;

    @Column(name="refresh_token",columnDefinition = "text", nullable = true)
    private String refreshToken;

    @Column(name="login_time",nullable = false)
    private LocalDateTime loginTime;

    @Column(name="logout_time",nullable = true)
    private LocalDateTime logoutTime;

    //	1 = Active, 0 = Inactive
    @Column(name="status",columnDefinition = " int4 NOT NULL")
    private int status;

    @Column(name="channel",columnDefinition = " varchar(225) NOT NULL")
    private String channel;

    @Column(name="device_info",columnDefinition = " varchar(225)")
    private String deviceInfo;

    @Column(name="created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
