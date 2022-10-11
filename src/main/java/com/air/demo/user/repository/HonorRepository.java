package com.air.demo.user.repository;

import com.air.demo.user.Entity.host.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonorRepository extends JpaRepository <Host, Long>{
}
