package com.air.demo.masterData.Repository;

import com.air.demo.masterData.entity.MasterLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterLanguageRepository extends JpaRepository<MasterLanguage,Long> {
}
