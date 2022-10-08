package com.example.demo.user.serviceImpl;

import com.example.demo.user.repository.HonorRepository;
import com.example.demo.user.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HonorServiceImpl implements HostService {

    @Autowired
    HonorRepository honorRepository;

    @Override
    public String honorIntrest() {
        return "yes its working";
    }
}
