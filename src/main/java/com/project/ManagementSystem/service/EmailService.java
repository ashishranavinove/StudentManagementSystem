package com.project.ManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ManagementSystem.model.Email;

@Service
public class EmailService {
	
	 private JavaMailSender javaMailSender;

	    @Autowired
	    public EmailService(JavaMailSender javaMailSender){
	        this.javaMailSender = javaMailSender;
	    }
   
	@Transactional
     public void sendNotification(Email email) throws MailException{
          
         StringBuilder sb = new StringBuilder();
         sb.append("Name: " + email.getName()).append(System.lineSeparator());
         sb.append("\n Message: " + email.getMessage());
          
         SimpleMailMessage mail = new SimpleMailMessage();
          
         mail.setTo(email.getEmail());
         mail.setFrom("emailremoved@gmail.com");
         mail.setSubject(email.getMessage());
         mail.setText(sb.toString());
          
         javaMailSender.send(mail);
         }      
      
}