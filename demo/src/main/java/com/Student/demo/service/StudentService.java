package com.Student.demo.service;

import com.Student.demo.entity.Student;

public interface StudentService {
	
	
	Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
	Student getStudentById(Long id);

}
