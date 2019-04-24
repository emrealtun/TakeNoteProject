package com.emre.service;

import com.emre.takenotproject1.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void registerMail(String mail,String  key)
    {
        SimpleMailMessage email=  new SimpleMailMessage();
        email.setFrom("altunemre956@gmail.com");
        email.setTo(mail);
        email.setSubject("Üyeliği tamamla");
        email.setText("Üyeliği tamamlamak için aşağıdaki linke tıklayın"
                +HomeController.url+"/reg/"+key);
        mailSender.send(email);
    }
}
