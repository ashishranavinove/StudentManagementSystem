package com.project.ManagementSystem.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.ManagementSystem.model.User;
import com.project.ManagementSystem.service.AdminService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AdminController {
	
    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
	PasswordEncoder encoder;

	@GetMapping("admin")
	 public ResponseEntity<List<User>> getAllList()
	 {
		 
		 LOG.info("Start getAllList of AdminController");
	        try {
	        	List<User> users=adminService.getAllList();
	            LOG.info("End getAllList of AdminController");
	            return  new ResponseEntity(users, HttpStatus.OK);

	        } catch (Exception e) {
	            e.printStackTrace();
	            LOG.error("End getAllList of AdminController" + e.getMessage());
	            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
		 	 
	 }
	
	@DeleteMapping("admin/{id}")
	 public ResponseEntity<Void> deleteuser(@PathVariable Long id)
	 {
		 LOG.info("Start deleteuser of AdminController");
	        try {
	        	adminService.deleteUser(id);
	            LOG.info("End deleteuser of StudentController");
	            return new ResponseEntity(HttpStatus.OK);

	        } catch (Exception e) {
	            e.printStackTrace();
	            LOG.error("End deleteuser of AdminController" + e.getMessage());
	            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	 }
	 

}
