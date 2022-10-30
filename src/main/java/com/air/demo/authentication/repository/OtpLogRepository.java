package com.air.demo.authentication.repository;

import com.air.demo.authentication.entites.OtpLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OtpLogRepository extends JpaRepository<OtpLog,Long> {
    //String otpViaValue, int otpVia,
    List<OtpLog> findByOtpViaValueAndOtpViaAndOtpSentAtGreaterThanEqualAndOtpSentAtLessThanEqualOrderByOtpSentAtDesc(String otpViaValue, int otpVia,LocalDateTime to,LocalDateTime from);

//OtpViaValueAndOtpViaAnd
    //OrderByOtpSentAtDesc
//findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);
//    List<Entity> findByColumnDateBetween(LocalDateTime to, LocalDateTime from);
//    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
//    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

}