package com.air.demo.authentication.repository;

import com.air.demo.authentication.entites.OtpLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OtpLogRepository extends JpaRepository<OtpLog,Long> {

    List<OtpLog> findByOtpViaValueAndOtpViaOrderByOtpSentAtAsc(String otpViaValue, int otpVia);


}