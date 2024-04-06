package com.adnanarch.securedoc.service.impl;

import com.adnanarch.securedoc.exception.ApiException;
import com.adnanarch.securedoc.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.adnanarch.securedoc.utils.EmailUtils.getEmailMessage;
import static com.adnanarch.securedoc.utils.EmailUtils.getResetPasswordMessage;


/**
 * Author: Adnan Rafique
 * Date: 4/6/2024
 * Time: 11:42 AM
 * Version: 1.0
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private static final String NEW_USER_ACCOUNT_VERIFICATION = "NEW User Account Verification";
    private static final String RESET_PASSWORD_REQUEST = "Reset Password Request";
    private final JavaMailSender emailSender;
    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Async
    @Override
    public void sendNewAccountEmail(String name, String email, String token) {
        try{
            var message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(getEmailMessage(name, email, token));
            emailSender.send(message);
        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("Unable to send the email");
        }
    }

    @Async
    @Override
    public void sendPasswordResetEmail(String name, String email, String token) {
        try{
            var message = new SimpleMailMessage();
            message.setSubject(RESET_PASSWORD_REQUEST);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(getResetPasswordMessage(name, email, token));
            emailSender.send(message);
        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new ApiException("Unable to send the email");
        }
    }


}
