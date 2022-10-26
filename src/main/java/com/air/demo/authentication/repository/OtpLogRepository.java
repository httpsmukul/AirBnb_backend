package com.air.demo.authentication.repository;

import com.air.demo.authentication.entites.OtpLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpLogRepository extends JpaRepository<OtpLog,Long> {
}
