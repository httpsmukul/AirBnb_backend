package com.air.demo.authentication.serviceImpl;


import com.air.demo.authentication.entites.OtpLog;
import com.air.demo.authentication.repository.OtpLogRepository;
import com.air.demo.authentication.service.SignUpService;
import com.air.demo.uttils.CommonUtils;
import com.air.demo.utilityDto.requestDto.SendOtpReqDto;
import com.air.demo.utilityDto.requestDto.SignUpReqDto;
import com.air.demo.utilityDto.requestDto.ValidatedOtpReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    private Environment environment;

    @Autowired
    OtpLogRepository otpLogRepository;

    @Override
    public ResponseDto sendOtp(SendOtpReqDto sendOtp) {

        System.out.println("printing email");
        System.out.println(environment.getProperty("email"));
        System.out.println("yes next l;ine ");
        String otpViaValueType = null;

        OtpLog otpLog = new OtpLog();

        if(commonUtils.isEmail(sendOtp.getOtpViaValue())){
            otpViaValueType = "email";
            otpLog.setOtpVia(Integer.parseInt(Objects.requireNonNull(environment.getProperty("email"))));
            otpLog.setOtpViaValue(sendOtp.getOtpViaValue());
        }
        if(commonUtils.isMobileNumber(sendOtp.getOtpViaValue())){
            otpViaValueType = "mobile";
            System.out.println(environment.getProperty("mobile"));
            otpLog.setOtpVia(1);
        }

        if(sendOtp.getRoleId() == 4 || sendOtp.getRoleId() == 3){
            otpLog.setRole(sendOtp.getRoleId());
        }else{
            throw new ServiceException("This Role dose not exits");
        }
        int otp = commonUtils.getOtp();

        if(!Objects.isNull(otp)){

            otpLog.setOtp("1234");
        }

//        otpLog.setStatus(Integer.parseInt(environment.getProperty("active")));

        otpLog.setStatus(1);


        otpLogRepository.save(otpLog);
        ResponseDto responseDto = new ResponseDto();

        responseDto.setData("Successfully added");
        responseDto.setStatus(true);
        responseDto.setMessage("SUCCESS");
        return responseDto;
    }

    @Override
    public ResponseDto validateOtp(ValidatedOtpReqDto validatedOtpReq) {
        return null;
    }
    @Override
    public ResponseDto userSignUp(SignUpReqDto signUpReq) {
        return null;
    }




}
