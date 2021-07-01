package com.project.ManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ManagementSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

   
}
