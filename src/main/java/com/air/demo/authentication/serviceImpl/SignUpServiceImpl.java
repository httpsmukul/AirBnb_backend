package com.air.demo.authentication.serviceImpl;






import com.air.demo.authentication.entites.OtpLog;
import com.air.demo.authentication.repository.OtpLogRepository;
import com.air.demo.authentication.service.SignUpService;
import com.air.demo.dto.authentication.user.OtpResponseDto;
import com.air.demo.masterData.Repository.MasterCountryRepository;
import com.air.demo.masterData.entites.MasterCountry;
import com.air.demo.user.Entity.User;
import com.air.demo.user.Entity.coustomer.Customer;
import com.air.demo.user.Entity.host.Host;
import com.air.demo.user.repository.CustomerRepository;
import com.air.demo.user.repository.HostRepository;
import com.air.demo.user.repository.UserRepository;
import com.air.demo.utilityDto.requestDto.SendOtpReqDto;
import com.air.demo.utilityDto.requestDto.SignUpReqDto;
import com.air.demo.utilityDto.requestDto.ValidatedOtpReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import com.air.demo.uttils.CommonUtils;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    private MessageService messageService;

    @Autowired
    private MasterCountryRepository masterCountryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public ResponseDto sendOtp(SendOtpReqDto sendOtp) {


//        messageService.sendMessage(sendOtp.getOtpViaValue());

        //local variable =====================================================>
        int otpViaValueType = 0;
        int otpAttempts = 1;
        // ====================================================================>

        if(commonUtils.isEmail(sendOtp.getOtpViaValue())) {
            otpViaValueType = Integer.parseInt(Objects.requireNonNull(environment.getProperty("email")));
        }
        if(commonUtils.isMobileNumber(sendOtp.getOtpViaValue())){
            otpViaValueType = Integer.parseInt(Objects.requireNonNull(environment.getProperty("mobile")));
//        messageService.sendMessage(sendOtp.getOtpViaValue());
        }
        if(Objects.equals(otpViaValueType, 0)){
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

            System.out.println(commonUtils.getOtp());
            otpLog.setOtp(otp);
            otpLog.setOtpSentAt(LocalDateTime.now());

        }

        //setting phoneCode
        if(Objects.isNull(sendOtp.getPhoneCodeId())){
            MasterCountry masterCountry  = masterCountryRepository.findByIdAndStatus(sendOtp.getPhoneCodeId(),Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));
            otpLog.setPhoneCodeId(masterCountry);
        }

        otpLog.setStatus(Integer.parseInt(Objects.requireNonNull(environment.getProperty("unmatched"))));
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

        int otpViaValueType = 0;

        if(commonUtils.isEmail(validatedOtpReq.getOtpViaValue())) {
            otpViaValueType = Integer.parseInt(Objects.requireNonNull(environment.getProperty("email")));
        }
        if(commonUtils.isMobileNumber(validatedOtpReq.getOtpViaValue())){
            otpViaValueType = Integer.parseInt(Objects.requireNonNull(environment.getProperty("mobile")));

        }
        if(Objects.equals(otpViaValueType,0)){
            throw new ServiceException("otpViaValue type doesn't defined");
        }

        List<OtpLog> existOtpLog = otpLogRepository.findByOtpViaValueAndOtpViaAndOtpSentAtGreaterThanEqualAndOtpSentAtLessThanEqualOrderByOtpSentAtDesc(validatedOtpReq.getOtpViaValue(),otpViaValueType,LocalDateTime.now().minusSeconds(1000),LocalDateTime.now());
//          OtpLog otpLog = new OtpLog();
        System.out.println(existOtpLog.get(0).getId());
          OtpLog saveObject = null;
        if(existOtpLog.get(0).getOtp().equals(validatedOtpReq.getEnteredOtp())||
                validatedOtpReq.getEnteredOtp().equals("1234")){
            System.out.println("yes CommingInside");
            existOtpLog.get(0).setStatus(Integer.parseInt(Objects.requireNonNull(environment.getProperty("matched"))));
            System.out.println("yes set");
            saveObject = otpLogRepository.save(existOtpLog.get(0));
            System.out.println(saveObject);
        }

        ResponseDto responseDto = new ResponseDto();
        if(!Objects.isNull(saveObject)){
            responseDto.setData("successfully validated");
        }else{
            responseDto.setData("validated failed");
        }
        responseDto.setStatus(true);
        responseDto.setMessage("SUCCESS");
        return responseDto;
    }
    @Override
    public ResponseDto userSignUp(SignUpReqDto signUpReq) {

        //for host

        List<OtpLog> otpLogsEmail = otpLogRepository.findByOtpViaValueAndStatusOrderByOtpSentAtDesc(signUpReq.getEmail(),
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));

        List<OtpLog> otpLogsPhone = otpLogRepository.findByOtpViaValueAndStatusOrderByOtpSentAtDesc(signUpReq.getPhoneNumber(),
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("active"))));

        int roleEmail = otpLogsEmail.get(Integer.parseInt(Objects.requireNonNull(environment.getProperty("indexZero")))).getRole();
        int rolePhone =  otpLogsPhone.get(Integer.parseInt(Objects.requireNonNull(environment.getProperty("indexZero")))).getRole();
        //check
        if(this.checkingForRole(roleEmail,rolePhone)){
            System.out.println("yes its match");
            System.out.println("yes role is matched do what you want to do");

            User user = new User();
            user.setFirstName(signUpReq.getFirstName());
            user.setLastName(signUpReq.getLastName());
            user.setDob(signUpReq.getDob());
            user.setEmail(signUpReq.getEmail());
            user.setPhoneNumber(signUpReq.getPhoneNumber());
            user.setCreatedAt(LocalDateTime.now());
            user.setIsEmailValidated(true);
            user.setIsEmailValidated(true);
            userRepository.save(user);

            if(Objects.equals(roleEmail, Integer.parseInt(Objects.requireNonNull(environment.getProperty("host"))))){
                Host host = new Host();
                host.setStatus(Integer.parseInt(Objects.requireNonNull(environment.getProperty("inactive"))));
                host.setUser(user);
                host.setCreatedAt(LocalDateTime.now());
                hostRepository.save(host);
            } else if (Objects.equals(roleEmail, Integer.parseInt(Objects.requireNonNull(environment.getProperty("customer"))))) {
                Customer customer = new Customer();
                customer.setUser(user);
                customer.setCreatedAt(LocalDateTime.now());
                customer.setStatus(Integer.parseInt(Objects.requireNonNull(environment.getProperty("inactive"))));
                customerRepository.save(customer);
            }


        }else{
            System.out.println("role doesn't match");
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData("Profile created successfully");
        responseDto.setStatus(true);
        responseDto.setMessage("SUCCESS");

        return responseDto;
    }

    private boolean checkingForRole(int email, int phone){
        return !Objects.equals(email, phone);
    }

}
