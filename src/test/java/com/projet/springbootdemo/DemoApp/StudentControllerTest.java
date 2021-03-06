//package com.projet.springbootdemo.DemoApp;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.HttpClientErrorException;
//
//import com.projet.ManagementSystem.AppApplication;
//import com.projet.ManagementSystem.model.Student;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class StudentControllerTest {
//	
//	 @Autowired
//     private TestRestTemplate restTemplate;
//
//	 private String getRootUrl() {
//         return "http://localhost:8080";
//     }
//	 @Test
//     public void contextLoads() {
//
//     }
//
//     @Test
//     public void testGetAllStudents() {
//     HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/student",
//        HttpMethod.GET, entity, String.class);  
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    public void testGetStudentById() {
//        Student student = restTemplate.getForObject(getRootUrl() + "/student/1", Student.class);
//        System.out.println(student.getFirstName());
//        assertNotNull(student);
//    }
//
//    @Test
//    public void testCreateStudent() {
//        Student student = new Student();
//        student.setFirstName("admin");
//        student.setLastName("member");
//        student.setFatherName("father");
//        student.setEmail("admin@gmail.com");
//        student.setCourse("cbca");
//        student.setMobileNumber((long) 1555555555);
//        student.setStreetAddress("ring road");
//        student.setCity("dwarka");
//        student.setState("adcf");
//        student.setPinCode((long) 584558);    
//        	       
//        ResponseEntity<Student> postResponse = restTemplate.postForEntity(getRootUrl() + "/student", student, Student.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//    }
//
//    @Test
//    public void testUpdateStudent() {
//        int id = 1;
//        Student student = restTemplate.getForObject(getRootUrl() + "/student/" + id, Student.class);
//        student.setFirstName("admin1");
//        student.setLastName("member1");
//        student.setFatherName("fatheras");
//        student.setEmail("admisn@gmail.com");
//        student.setCourse("cbcsa");
//        student.setMobileNumber((long) 1555555555);
//        student.setStreetAddress("rinxg road");
//        student.setCity("dwaxrka");
//        student.setState("adxcf");
//        student.setPinCode((long) 684558);
//        restTemplate.put(getRootUrl() + "/student/" + id, student);
//        Student updatedStudent = restTemplate.getForObject(getRootUrl() + "/student/" + id, Student.class);
//        assertNotNull(updatedStudent);
//    }
//
//    @Test
//    public void testDeleteEmployee() {
//         int id = 2;
//         Student student = restTemplate.getForObject(getRootUrl() + "/student/" + id, Student.class);
//         assertNotNull(student);
//         restTemplate.delete(getRootUrl() + "/student/" + id);
//         try {
//              student = restTemplate.getForObject(getRootUrl() + "/student/" + id, Student.class);
//         } catch (final HttpClientErrorException e) {
//              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//         }
//    }
//
//
//}
