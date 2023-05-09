package com.example.notification1.service;

import com.example.notification1.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender emailSernder;

    public void sendTo(String email, String title, String text) {
        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(email);
        sms.setFrom("whanau.gda@gmail.com");
        sms.setSubject(title);
        sms.setText(text);
        emailSernder.send(sms);
    }
}
