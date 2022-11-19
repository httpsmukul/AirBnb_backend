package com.air.demo.authentication.serviceImpl;


import com.air.demo.authentication.service.SignInService;
import com.air.demo.user.Entity.user.User;
import com.air.demo.user.Entity.user.UserLoginToken;
import com.air.demo.user.repository.AuthorizationRepository;
import com.air.demo.user.repository.UserRepository;
import com.air.demo.utilityDto.requestDto.SignInReqDto;
import com.air.demo.utilityDto.responseDto.ResponseDto;
import com.air.demo.uttils.CommonUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    Environment environment;

    @Autowired
    AuthorizationRepository authorizationRepository;

    private void logInValidation(SignInReqDto signInReqDto){

        if(signInReqDto.getUserName().isEmpty()){
            throw new ServiceException("userName should not be empty");
        }

        if(signInReqDto.getChannel().isEmpty()){
            throw new ServiceException("Channel should not be empty");
        }

        if(signInReqDto.getPassword().isEmpty()){
           throw new ServiceException("password should not be empty");
        }
    }

    private int userNameIdentifier(SignInReqDto signInReqDto){

        int typeOfUserName = 0;
        if (commonUtils.isEmail(signInReqDto.getUserName())) {
            typeOfUserName = Integer.parseInt(Objects.requireNonNull(environment.getProperty("email")));
        }
        if (commonUtils.isMobileNumber(signInReqDto.getUserName())) {
            typeOfUserName = Integer.parseInt(Objects.requireNonNull(environment.getProperty("phone")));
        }
        if (Objects.equals(typeOfUserName, 0)) {
            throw new ServiceException("userName type doesn't defined");
        }

        return typeOfUserName;
    }

    @Override
    public ResponseDto logInUser(SignInReqDto signInReqDto) {

        logInValidation(signInReqDto);

        int typeOfUserName = userNameIdentifier(signInReqDto);

        User requestedUser  = null;

        if(typeOfUserName == Integer.parseInt("email")){
            requestedUser = userRepository.findByEmail(signInReqDto.getUserName());
        }

        if(typeOfUserName == Integer.parseInt("phone")){
            requestedUser = userRepository.findByEmail(signInReqDto.getUserName());
        }


        if (Objects.requireNonNull(requestedUser).getPassword().equals(signInReqDto.getPassword())) {

        }






        return null;
    }

    @Override
    public ResponseDto logOutUser(String Authorization) {

        UserLoginToken userLoginToken = authorizationRepository.findByToken(Authorization);

        authorizationRepository.delete(userLoginToken);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setData("successfully logout");
        responseDto.setStatus(true);
        responseDto.setMessage("SUCCESS");

        return responseDto;
    }


}
