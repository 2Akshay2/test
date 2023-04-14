package com.Student.demo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.demo.entity.Student;
import com.Student.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        // Validate student data
        validateStudent(student);

        // Calculate total and average marks
        int total = student.getMarks1() + student.getMarks2() + student.getMarks3();
        double average = total / 3.0;

        // Determine result based on minimum marks requirement
        String result = (student.getMarks1() >= 35 && student.getMarks2() >= 35 && student.getMarks3() >= 35) ? "Pass" : "Fail";

        // Set calculated fields on student object
        student.setTotal(total);
        student.setAverage(average);
        student.setResult(result);

        // Save student to database
        return studentRepository.save(student);
    }

    
    public Student updateStudent(Long id, Student student) {
        // Find student by ID
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            throw new RuntimeException("Student with ID " + id + " not found");
        }

        // Get existing student object
        Student existingStudent = optionalStudent.get();

        // Update existing student fields
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setDob(student.getDob());
        existingStudent.setSection(student.getSection());
        existingStudent.setGender(student.getGender());
        existingStudent.setMarks1(student.getMarks1());
        existingStudent.setMarks2(student.getMarks2());
        existingStudent.setMarks3(student.getMarks3());

        // Validate updated student data
        validateStudent(existingStudent);

        // Calculate total and average marks
        int total = existingStudent.getMarks1() + existingStudent.getMarks2() + existingStudent.getMarks3();
        double average = total / 3.0;

        // Determine result based on minimum marks requirement
        String result = (existingStudent.getMarks1() >= 35 && existingStudent.getMarks2() >= 35 && existingStudent.getMarks3() >= 35) ? "Pass" : "Fail";

        // Set calculated fields on existing student object
        existingStudent.setTotal(total);
        existingStudent.setAverage(average);
        existingStudent.setResult(result);

        // Save updated student to database
        return studentRepository.save(existingStudent);
    }

    private void validateStudent(Student student) {
        // Validate first name and last name length
        if (student.getFirstName().length() < 3 || student.getLastName().length() < 3) {
            throw new RuntimeException("First name and last name must be at least 3 characters long");
        }

        // Validate DOB
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(student.getDob(), currentDate).getYears();
        if (age <= 15 || age > 20) {
            throw new RuntimeException("DOB must be between 16 and 20 years ago");
        }

        // Validate marks range
        if (student.getMarks1() != null && (student.getMarks1() < 0 || student.getMarks1() > 100)) {
            throw new RuntimeException("Marks 1 must be between 0 and 100");
        }
        if (student.getMarks2() != null && (student.getMarks2() < 0 || student.getMarks2() > 100)) {
            throw new RuntimeException("Marks 2 must be between 0 and 100");
        }
    }
}
       
	
	

