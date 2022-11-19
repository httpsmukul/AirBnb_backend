package com.air.demo.user.repository;

import com.air.demo.user.Entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByPhoneNumber(String phone);

    User findByEmailOrPhoneNumber(String email,String phone);



}