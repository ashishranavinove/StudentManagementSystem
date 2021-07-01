package com.project.ManagementSystem.rest;

import java.util.List;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ManagementSystem.dto.StudentDTO;
import com.project.ManagementSystem.Repository.StudentRepository;
import com.project.ManagementSystem.model.Student;
import com.project.ManagementSystem.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StudentController {
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
    
    @Autowired
    private StudentService studentService;
    
	@Autowired
	private StudentRepository studentRepository; 

	 @PostMapping("student")
	  public ResponseEntity<Void> addStudent(@RequestBody StudentDTO studentDTO, HttpServletRequest request) {

		 LOG.info("Start addStudent of StudentController");
	        try {
	        	studentService.addStudent(studentDTO);
	            LOG.info("End addStudent of StudentController");
	            return new ResponseEntity(HttpStatus.OK);

	        } catch (Exception e) {
	            e.printStackTrace();
	            LOG.error("End addStudent of StudentController" + e.getMessage());
	            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
     }
	 
	 @DeleteMapping("student/{studentId}")
	 public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId)
	 {
		 LOG.info("Start deleteStudent of StudentController");
	        try {
	        	studentService.deleteStudent(studentId);
	            LOG.info("End deleteStudent of StudentController");
	            return new ResponseEntity(HttpStatus.OK);

	        } catch (Exception e) {
	            e.printStackTrace();
	            LOG.error("End deleteStudent of StudentController" + e.getMessage());
	            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	 }
	 
	 @GetMapping("student")
	 public ResponseEntity<List<Student>> getAllStudent()
	 {
		 
		 LOG.info("Start getAllStudent of StudentController");
	        try {
	        	List<Student> students=studentService.getAllStudents();
	            LOG.info("End getAllStudent of StudentController");
	            return  new ResponseEntity(students, HttpStatus.OK);

	        } catch (Exception e) {
	            e.printStackTrace();
	            LOG.error("End getAllStudent of StudentController" + e.getMessage());
	            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
		 	 
	 }
	 
	 @GetMapping("student/{id}")
	    public ResponseEntity<Student> getEmployeeById(@PathVariable(value = "id") Long employeeId)
	        throws RelationNotFoundException {
	        Student student = studentRepository.findById(employeeId)
	          .orElseThrow(() -> new RelationNotFoundException("Employee not found for this id :: " + employeeId));
	        return ResponseEntity.ok().body(student);
	    }
	 
	 @PutMapping("/student/{id}")
	    public ResponseEntity<Student> updateEmployee(@PathVariable(value = "id") Long id,
	         @Valid @RequestBody StudentDTO studentDTO) throws RelationNotFoundException {
	        Student student = studentRepository.findById(id)
	        .orElseThrow(() -> new RelationNotFoundException("Employee not found for this id :: " + id));

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
	        final Student updatedStudent = studentRepository.save(student);
	        return ResponseEntity.ok(updatedStudent);
	    }
	 
}
