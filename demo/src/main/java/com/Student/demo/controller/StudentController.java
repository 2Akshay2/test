package com.Student.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.demo.entity.Student;
import com.Student.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<?> createStudent(@RequestBody @Validated Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody @Validated Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
    }
    
    
    
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateMarks(@PathVariable Long id, @RequestBody Map<String, Integer> marks) {
        Student student = studentService.getStudentById(id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        Integer marks1 = marks.get("marks1");
        Integer marks2 = marks.get("marks2");
        Integer marks3 = marks.get("marks3");
        if(marks1 == null || marks2 == null || marks3 == null) {
            return ResponseEntity.badRequest().body("Missing marks data");
        }
        student.setMarks1(marks1);
        student.setMarks2(marks2);
        student.setMarks3(marks3);
        studentService.updateStudent(id, student);
        return ResponseEntity.ok().build();
    }
}
