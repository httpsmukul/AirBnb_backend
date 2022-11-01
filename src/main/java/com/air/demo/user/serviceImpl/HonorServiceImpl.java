package com.air.demo.user.serviceImpl;

import com.air.demo.user.repository.HostRepository;
import com.air.demo.user.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HonorServiceImpl implements HostService {

    @Autowired
    HostRepository honorRepository;

    @Override
    public String honorIntrest() {
        return "yes its working";
    }
}
