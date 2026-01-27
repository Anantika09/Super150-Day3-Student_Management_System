package com.example.day3_studentmanagementsystem.service;

import com.example.day3_studentmanagementsystem.model.StudentModel;
import com.example.day3_studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //create student
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

    //display student
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    //update student
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent=repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());
        return repository.save(existingStudent);
    }

    //delete student
    public void deleteStudent(String id){
        repository.deleteById(id);
    }
}
