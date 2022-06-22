package com.controlfit.planmensual.web;

import com.controlfit.planmensual.service.SendMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class InitController {

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/")
    public String inicio() {
        //El template al que se comparte
        return "index.html";
    }

    @PostMapping("/sendMail")
    public String sendMail() {
        
        
        String from = "correoQueEnvia@gmail.com";
        String to = "correoQueRecibe@gmail.com";
        String subject = "Prueba!!!";
        String message = "Mensaje de prueba";
        sendMailService.sendMail(from, to, subject, message);
        
        return "redirect:/";
    }

}