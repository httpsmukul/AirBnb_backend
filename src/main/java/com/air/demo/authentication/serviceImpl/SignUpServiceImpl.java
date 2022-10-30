package com.air.demo.authentication.serviceImpl;






import com.air.demo.authentication.entites.OtpLog;
import com.air.demo.authentication.repository.OtpLogRepository;
import com.air.demo.authentication.service.SignUpService;
import com.air.demo.dto.authentication.user.OtpResponseDto;
import com.air.demo.masterData.Repository.MasterCountryRepository;
import com.air.demo.masterData.entites.MasterCountry;
import com.air.demo.utilityDto.requestDto.SendOtpReqDto;
import com.air.demo.utilityDto.requestDto.SignUpReqDto;
import com.air.demo.utilityDto.requestDto.ValidatedOtpReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import com.air.demo.uttils.CommonUtils;
import net.bytebuddy.asm.Advice;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.message.Message.*;

@Service
@Configuration
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private Environment environment;


    @Autowired
    private CommonUtils commonUtils;

    @Autowired
    private OtpLogRepository otpLogRepository;

    @Autowired
    private MasterCountryRepository masterCountryRepository;

    @Override
    public ResponseDto sendOtp(SendOtpReqDto sendOtp) {

        //local variable =====================================================>
        int otpViaValueType = 0;
        int otpAttempts = 1;
        // ====================================================================>

        if(commonUtils.isEmail(sendOtp.getOtpViaValue())) {
            otpViaValueType = Integer.parseInt(environment.getProperty("email"));
        }
        if(commonUtils.isMobileNumber(sendOtp.getOtpViaValue())){
            otpViaValueType = Integer.parseInt(environment.getProperty("mobile"));

        }
        if(otpViaValueType == 0){

            throw new ServiceException("otpViaValue type doesn't defined");
        }


        List<OtpLog> existOtpLog = otpLogRepository.findByOtpViaValueAndOtpViaAndOtpSentAtGreaterThanEqualAndOtpSentAtLessThanEqualOrderByOtpSentAtDesc(sendOtp.getOtpViaValue(),otpViaValueType,LocalDateTime.now().minusSeconds(30),LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().minusSeconds(30));
        System.out.println(LocalDateTime.now().plusSeconds(30));
        System.out.println("yes here 60 " +existOtpLog.size());
        System.out.println(existOtpLog.stream().map(OtpLog::getId).collect(Collectors.toList()));
        System.out.println("yes here in 62");
        OtpLog otpLog = new OtpLog();

        if(!Objects.isNull(existOtpLog)){

            if(Objects.equals(existOtpLog.size(),Integer.parseInt(Objects.requireNonNull(environment.getProperty("otpAttemptsCount"))))){
                throw new ServiceException("because of so many attempts wait for next 30 sec");
            }
//            for(int i = 0; i<existOtpLog.size();i++){
//                otpAttempts += existOtpLog.get(i).getOtpAttempts();
//            }
            otpAttempts += existOtpLog.size();
        }



        if(otpViaValueType == (Integer.parseInt(Objects.requireNonNull(environment.getProperty("email"))))){
            otpLog.setOtpVia(Integer.parseInt(Objects.requireNonNull(environment.getProperty("email"))));
            otpLog.setOtpViaValue(sendOtp.getOtpViaValue());
        }
        if(otpViaValueType == Integer.parseInt(Objects.requireNonNull(environment.getProperty("mobile")))){
            System.out.println(environment.getProperty("mobile"));
            otpLog.setOtpVia(Integer.parseInt(Objects.requireNonNull(environment.getProperty("mobile"))));
            otpLog.setOtpViaValue(sendOtp.getOtpViaValue());

        }

        if(sendOtp.getRoleId() == Integer.parseInt(Objects.requireNonNull(environment.getProperty("host")))
                || sendOtp.getRoleId() == Integer.parseInt(Objects.requireNonNull(environment.getProperty("customer")))){
            otpLog.setRole(sendOtp.getRoleId());
        }else{
            throw new ServiceException("This Role dose not exits");
        }
        String otp = commonUtils.getOtp();

        if(!Objects.isNull(otp)){



            System.out.println("here i am printing otp");
            System.out.println(commonUtils.getOtp());
            otpLog.setOtp(otp);
            otpLog.setOtpSentAt(LocalDateTime.now());

        }

        //setting phoneCode
        if(Objects.isNull(sendOtp.getPhoneCodeId())){
            MasterCountry masterCountry  = masterCountryRepository.findByIdAndStatus(sendOtp.getPhoneCodeId(),Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));
            otpLog.setPhoneCodeId(masterCountry);
        }

        otpLog.setStatus(Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));
        otpLog.setOtpAttempts(otpAttempts);
        System.out.println("checking");
        otpLogRepository.save(otpLog);
        ResponseDto responseDto = new ResponseDto();

        OtpResponseDto otpResponseDto = new OtpResponseDto();
        otpResponseDto.setOtpAttempts(otpAttempts);
        responseDto.setData(otpResponseDto);
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
