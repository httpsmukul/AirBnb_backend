package com.air.demo.common.uttils;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CommonUtils {

    public boolean isEmail(String data){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (data == null)
            return false;
        return pat.matcher(data).matches();

    }

    public boolean isMobileNumber(String data){
        // The given argument to compile() method
        // is regular expression. With the help of
        // regular expression we can validate mobile
        // number.
        // The number should be of 10 digits.

        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        Matcher m = p.matcher(data);

        // Returning boolean value
        return (m.matches());
    }

        public String getOtp() {
            int min = 1;
            int max = 10000;
            //Generate random int value from 50 to 100
//            System.out.println("Random value in int from "+min+" to "+max+ ":");
            //            System.out.println(random_int);
            Random random = new Random();

            return String.format("%04d", random.nextInt(10000));
        }




}
