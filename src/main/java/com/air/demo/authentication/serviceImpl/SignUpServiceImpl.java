package com.air.demo.authentication.serviceImpl;


import com.air.demo.authentication.entites.OtpLog;
import com.air.demo.authentication.service.SignUpService;
import com.air.demo.commonUtils.uttils.CommonUtils;
import com.air.demo.utilityDto.requestDto.SendOtpReqDto;
import com.air.demo.utilityDto.requestDto.SignUpReqDto;
import com.air.demo.utilityDto.requestDto.ValidatedOtpReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    CommonUtils commonUtils;

    @Override
    public ResponseDto sendOtp(SendOtpReqDto sendOtp) {

        String otpViaValueType = null;

        if(commonUtils.isEmail(sendOtp.getOtpViaValue())){
            otpViaValueType = "email";
        }
        if(commonUtils.isMobileNumber(sendOtp.getOtpViaValue())){
            otpViaValueType = "mobile";
        }

        System.out.println("34+++++++++++line"+otpViaValueType);
//        if()


        OtpLog otpLog = new OtpLog();

        if(sendOtp.getRoleId() == 3 || sendOtp.getRoleId() == 4){
            otpLog.setRole(sendOtp.getRoleId());
        }else{
            System.out.println("check your roleId");
        }








        ResponseDto responseDto = new ResponseDto();

        responseDto.setData("yes you are in");
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
