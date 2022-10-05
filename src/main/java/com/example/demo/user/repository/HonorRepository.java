package com.example.demo.user.repository;

import com.example.demo.user.coustomer.Customer;
import com.example.demo.user.honor.Honor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface HonorRepository extends JpaRepository <Honor, Long>{
}
