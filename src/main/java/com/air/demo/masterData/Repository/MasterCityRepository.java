package com.air.demo.masterData.Repository;

import com.air.demo.masterData.entity.MasterCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterCityRepository extends JpaRepository<MasterCity,Long > {

     MasterCity findByIdAndStatus(Long id,int status);

}
