package com.air.demo.user.serviceImpl;

import com.air.demo.user.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public String aboutCustomer() {
        return "yes its customer";
    }
}
