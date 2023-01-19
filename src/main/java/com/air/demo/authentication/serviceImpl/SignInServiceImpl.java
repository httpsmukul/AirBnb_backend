package com.air.demo.authentication.serviceImpl;


import com.air.demo.authentication.service.SignInService;
import com.air.demo.user.Entity.user.User;
import com.air.demo.user.Entity.user.UserLoginToken;
import com.air.demo.user.repository.AuthorizationRepository;
import com.air.demo.user.repository.UserRepository;
import com.air.demo.common.utilityDto.requestDto.SignInReqDto;
import com.air.demo.common.utilityDto.responseDto.ResponseDto;
import com.air.demo.common.uttils.CommonUtils;
import com.air.demo.common.uttils.JwtUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
    private JwtUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUserDetailsService userDetailsService;

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
        System.out.println("yes its reach 80");

//        logInValidation(signInReqDto);

//        int typeOfUserName = userNameIdentifier(signInReqDto);

        User requestedUser  = userRepository.findByUserName(signInReqDto.getUserName());

        System.out.println("line88");
        System.out.println(requestedUser.getUserName());
        System.out.println(requestedUser.getPassword());
        if(Objects.isNull(requestedUser)){
            throw new ServiceException("user not found");
        }

//        if(typeOfUserName == Integer.parseInt("email")){
//            requestedUser = userRepository.findByEmail(signInReqDto.getUserName());
//        }
//
//        if(typeOfUserName == Integer.parseInt("phone")){
//            requestedUser = userRepository.findByEmail(signInReqDto.getUserName());
//        }



//        if (Objects.requireNonNull(requestedUser).getPassword().equals(signInReqDto.getPassword())) {
//
//        }

        try {
            authenticationManager.authenticate(

                    new UsernamePasswordAuthenticationToken(requestedUser.getUserName(), signInReqDto.getPassword())
            );
            System.out.println("Line110");

        }
        catch (BadCredentialsException e) {
            throw new ServiceException("Incorrect username or password", e);
        }catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("Incorrect username or password", e);
        }

        System.out.println("line114");
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(signInReqDto.getUserName());
        System.out.println("line117");

        final String jwt = jwtTokenUtil.generateToken(userDetails);

       ResponseDto responseDto = new ResponseDto();
       responseDto.setData("Bearer "+jwt);
       responseDto.setStatus(true);
       responseDto.setMessage("SCUESS");
        return responseDto;
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
