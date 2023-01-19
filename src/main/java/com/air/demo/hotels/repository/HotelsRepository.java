package com.air.demo.hotels.repository;

import com.air.demo.hotels.entites.Hotels;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels,Long> {

    List<Hotels> findAll(Specification<Hotels> specification);

}
