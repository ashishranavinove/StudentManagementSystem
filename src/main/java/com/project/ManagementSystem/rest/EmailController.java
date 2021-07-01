package com.project.ManagementSystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ManagementSystem.model.Email;
import com.project.ManagementSystem.service.EmailService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	   @PostMapping("sendemail")
	   public void signupSuccess(@RequestParam("subject") String subject, @RequestParam("message") String message, @RequestParam("email") String email, @RequestParam("name") String name) {
	        
	       Email email1 = new Email();
	       email1.setSubject(subject);
	       email1.setMessage(message);
	       email1.setEmail("emailremoved@gmail.com");
	       
	       email1.setName(name);
	       try {
	    	   emailService.sendNotification(email1);
	           
	       }catch(MailException e) {
	       }
	      
	   }
	
	
	
}
