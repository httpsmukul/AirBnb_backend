package com.air.demo.authentication.serviceImpl;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    @Autowired
    private Environment environment;

//    public static final String ACCOUNT_SID = environment.getProperty("ACCOUNT_SID");
//    public static final String AUTH_TOKEN = environment.getProperty("AUTH_TOKEN");

    public void sendMessage(String phoneTo) {
        TwilioRestClient client = new TwilioRestClient.Builder(environment.getProperty("ACCOUNT_SID"),
                environment.getProperty("AUTH_TOKEN")).build();
        System.out.println("yes till msg");
//        try {
        Message message = Message.creator(
                new PhoneNumber("+919675643803"),  // To number
                new PhoneNumber("+1 424 655 3243"),  // From number
                "Hello world 123!"                    // SMS body
        ).create(client);  // Pass the client here
        System.out.println(message.getSid());
//        } catch (final ApiException e) {
//            System.err.println(e);
//        }

        System.out.println("after msg");
    }
}
