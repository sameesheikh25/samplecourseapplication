package com.firstapp.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl extends SimpleMailMessage {
    @Autowired
    private JavaMailSender javaMailSender;
    private SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

    public void sendEmail(String to, String sub, String body) {
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(sub);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }
}
