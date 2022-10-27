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

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Configuration
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private Environment environment;


    @Autowired
    CommonUtils commonUtils;

    @Autowired
    OtpLogRepository otpLogRepository;




    @Override

    public ResponseDto sendOtp(SendOtpReqDto sendOtp) {

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
            otpLog.setOtpVia(Integer.parseInt(Objects.requireNonNull(environment.getProperty("mobile"))));
        }

        if(sendOtp.getRoleId() == Integer.parseInt(environment.getProperty("host"))
                || sendOtp.getRoleId() == Integer.parseInt(environment.getProperty("customer"))){
            otpLog.setRole(sendOtp.getRoleId());
        }else{
            throw new ServiceException("This Role dose not exits");
        }
        String otp = commonUtils.getOtp();

        if(!Objects.isNull(otp)){

            System.out.println("here i am printing otp");
            System.out.println(commonUtils.getOtp());
            otpLog.setOtp(otp);

        }

        otpLog.setStatus(Integer.parseInt(environment.getProperty("active")));

        System.out.println("checking");
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
