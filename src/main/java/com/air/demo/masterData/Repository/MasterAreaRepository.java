package com.air.demo.masterData.Repository;

import com.air.demo.masterData.entity.MasterArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterAreaRepository extends JpaRepository<MasterArea,Long> {

    MasterArea findByIdAndStatus(Long id,int status);
}
