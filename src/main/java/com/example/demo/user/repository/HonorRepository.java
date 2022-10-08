package com.example.demo.user.repository;

import com.example.demo.user.host.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonorRepository extends JpaRepository <Host, Long>{
}
