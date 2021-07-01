package com.project.ManagementSystem.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ManagementSystem.dto.StudentDTO;
import com.project.ManagementSystem.Repository.RoleRepository;
import com.project.ManagementSystem.Repository.UserRepository;
import com.project.ManagementSystem.model.Role;
import com.project.ManagementSystem.model.RoleName;
import com.project.ManagementSystem.model.Student;
import com.project.ManagementSystem.model.User;

@Service
public class AdminService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
		
	@Transactional
	public List<User> getAllList()
	{
		List<User> users=userRepository.findAll();
		return users;
	}

	@Transactional
	public void deleteUser(Long id) {
	
		userRepository.deleteById(id);

	}
}
