package com.controlfit.planmensual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendMail(String from, String to, String subject, String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        
        mailSender.send(mailMessage);
        System.out.println("Mail sent successfully...");
    }
}
