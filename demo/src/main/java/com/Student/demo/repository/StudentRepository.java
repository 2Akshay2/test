package com.Student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
	Student findById(long id);

}
