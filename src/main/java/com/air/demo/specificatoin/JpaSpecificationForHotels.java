package com.air.demo.specificatoin;


import com.air.demo.hotels.entites.Hotels;
import com.air.demo.hotels.repository.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class JpaSpecificationForHotels implements Specification<Hotels> {

    @Autowired
    HotelsRepository hotelsRepository;

    private List<SearchCriteria> criteriaList;

    public JpaSpecificationForHotels(List<SearchCriteria> criteriaList) {
        super();
        this.criteriaList = criteriaList;

    }


    @Override
    public Predicate toPredicate(Root<Hotels> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicateList =  new ArrayList<>();

        predicateList.add(criteriaBuilder.notEqual(root.<Integer> get("status"),2));

//        predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.<String> get("address"), "some"));

        predicateList.add(criteriaBuilder.equal(root.<Boolean> get("address"),"Mumbai"));

//        predicateList.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("hotelName"))  , "%" + "oliva" + "%"));

        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        // this line is taking one by one and adding 1 by 1 with and
    }
}
