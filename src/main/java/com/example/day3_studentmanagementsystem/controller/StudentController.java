package com.example.day3_studentmanagementsystem.controller;

import com.example.day3_studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3_studentmanagementsystem.dto.StudentResponseDto;
import com.example.day3_studentmanagementsystem.model.StudentModel;
import com.example.day3_studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // create function api
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }

    // display students
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getStudents();
    }

    // update
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,@RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
    }
}
