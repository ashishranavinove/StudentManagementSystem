package com.project.ManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.ManagementSystem.dto.StudentDTO;
import com.project.ManagementSystem.Repository.StudentRepository;
import com.project.ManagementSystem.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;	
	
	@Transactional
	public void addStudent(StudentDTO studentDTO) {
			
        Student student=new Student();
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		student.setEmail(studentDTO.getEmail());
		student.setCourse(studentDTO.getCourse());
		student.setFatherName(studentDTO.getFatherName());
		student.setMobileNumber(studentDTO.getMobileNumber());
		student.setCity(studentDTO.getCity());
		student.setStreetAddress(studentDTO.getStreetAddress());
		student.setState(studentDTO.getState());
		student.setPinCode(studentDTO.getPinCode());
		studentRepository.save(student);
		
	}
	
	@Transactional
	public void deleteStudent(Long studentId) {

		studentRepository.deleteById(studentId);

	}          
                                                                                                                                                                                                                                                                
	
	@Transactional
	public List<Student> getAllStudents()
	{
		List<Student> students=studentRepository.findAll();
		return students;
	}
	
	
}
