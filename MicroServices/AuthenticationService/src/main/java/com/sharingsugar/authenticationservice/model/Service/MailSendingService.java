package com.sharingsugar.authenticationservice.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sharingsugar.authenticationservice.application.Request.LogingRequest;
import com.sharingsugar.authenticationservice.application.Response.UserInfoDto;
import com.sharingsugar.authenticationservice.model.Beans.FeignProxy;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSendingService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private FeignProxy feignProxy;

    public String sendMailForForgotPassWord(String userName) throws RuntimeException{
        try {
            UserInfoDto userInfoDto= feignProxy.getUserInfoDto(userName);
            LogingRequest logingRequest=new LogingRequest(userInfoDto.getUsername(), userInfoDto.getPassword());
            String token= authenticationService.getToken(logingRequest);
            System.out.println("took a token");
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(userInfoDto.getUsername());
            helper.setSubject("Forgot password");
            helper.setFrom("bhanukashehan9@gmail.com");

            // Add a clickable link
            String linkText = "Click Here";
            String linkUrl = "www.sharingsugar.com/resetpassword?token="+token;
            String link = "<a href='" + linkUrl + "'>" + linkText + "</a>";
            helper.setText("Please " + link + " to reset password.", true);

            javaMailSender.send(message);

            return token;

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
