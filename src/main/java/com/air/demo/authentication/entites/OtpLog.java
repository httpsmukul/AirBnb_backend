package com.air.demo.authentication.entites;

import com.air.demo.masterData.entity.MasterCountry;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class OtpLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="otp_via_value",columnDefinition=" VARCHAR(255) ")
    private String 	otpViaValue;
    // 1 = phone, 2 = email'

    @Column(name="otp_via",columnDefinition="INT4 NOT NULL")
    private int otpVia;

    @Column(name="otp",columnDefinition=" VARCHAR(255)  NOT NULL ")
    private String otp;

    @Column(name="otp_attempts",columnDefinition="INT4 NOT NULL")
    private int otpAttempts;
    //	signUpOtp = 1,loginOtp = 2,updateProfileOtp=3

    @Column(name="service_type",columnDefinition=" INT4")
    private Integer serviceType;

    @Column(name="otp_sent_at")
    private LocalDateTime otpSentAt;

    @Column(name="otp_window_start_time")
    private LocalDateTime otpWindowStartTime;

    //	 0=Unmatched, 1=Matched
    @Column(columnDefinition="INT4 NOT NULL ")
    private int status;

    @Column(name="request", columnDefinition="text")
    private int request;

    @Column(name="response", columnDefinition="text")
    private int response;

    @ManyToOne
    @JoinColumn(name="phone_code_id")
    private MasterCountry phoneCodeId;

    @Column(name="role_id")
    private int role;
    //1 = superAdmin
    //2 = Admin
    //3 = Host
    //4 = Customer

}
