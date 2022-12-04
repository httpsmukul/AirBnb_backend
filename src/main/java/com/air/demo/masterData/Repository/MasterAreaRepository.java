package com.air.demo.masterData.Repository;

import com.air.demo.masterData.entites.MasterArea;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterAreaRepository extends JpaRepository<MasterArea,Long> {

    MasterArea findByIdAndStatus(Long id,int status);
}
