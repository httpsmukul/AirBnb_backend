package com.air.demo.masterData.Repository;

import com.air.demo.masterData.entity.MasterCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterCountryRepository extends JpaRepository<MasterCountry,Long> {

    MasterCountry findByIdAndStatus(Long Id, int status);
}
