package com.Student.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "students" )
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;
    
    @NotBlank
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;
    
    @NotNull
    @Column(name = "dob")
    private LocalDate dob;
    
    @NotBlank
    @Pattern(regexp = "^[ABC]$")
    @Column(name = "section")
    private String section;
    
    @NotBlank
    @Pattern(regexp = "^[MF]$")
    @Column(name = "gender")
    private String gender;
    
    @NotNull
    @Min(0)
    @Column(name = "marks_1")
    private Integer marks1;
    
    @NotNull
    @Min(0)
    @Column(name = "marks_2")
    private Integer marks2;
    
    @NotNull
    @Min(0)
    @Column(name = "marks_3")
    private Integer marks3;
    
    @Transient
    private Integer total;
    
    @Transient
    private Double average;
    
    @Transient
    private String result;
    
    public Student() {
    }
    
    public Student(String firstName, String lastName, LocalDate dob, String section, String gender, Integer marks1, Integer marks2, Integer marks3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.section = section;
        this.gender = gender;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public LocalDate getDob() {
        return dob;
    }
    
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    public String getSection() {
        return section;
    }
    
    public void setSection(String section) {
        this.section = section;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Integer getMarks1() {
        return marks1;
    }
    
    public void setMarks1(Integer marks1) {
        this.marks1 = marks1;
    }
    
    public Integer getMarks2() {
        return marks2;
    }
    
    public void setMarks2(Integer marks2) {
        this.marks2 = marks2;
    }
    
    public Integer getMarks3() {
        return marks3;
    }
    
    public void setMarks3(Integer marks3) {
        this.marks3 = marks3;
    }
    
    public Integer getTotal() {
        return total;
    }
    
    public void setTotal(Integer total) {
        this.total = total;
    }
    
    public Double getAverage() {
        return average;
    }
    
    public void setAverage(Double average) {
        this.average = average;
    }
    
    public String getResult() {
		return null;}

	public void setResult(String result2) {
		
	}
    
}
