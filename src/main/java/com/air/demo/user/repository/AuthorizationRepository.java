package com.air.demo.user.repository;

import com.air.demo.user.Entity.user.UserLoginToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends JpaRepository<UserLoginToken,Long> {

    UserLoginToken findByToken(String Authorization);


}
