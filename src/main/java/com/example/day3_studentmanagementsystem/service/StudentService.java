package com.example.day3_studentmanagementsystem.service;

import com.example.day3_studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3_studentmanagementsystem.dto.StudentResponseDto;
import com.example.day3_studentmanagementsystem.exception.StudentNotFoundException;
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
//    public StudentModel addStudent(StudentModel student) {
//        return repository.save(student);
//    }


    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student=new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved=repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    //display student
//    public List<StudentModel> getStudents(){
//        return repository.findAll();
//    }
    public List<StudentResponseDto> getStudents(){
        return repository.findAll()
        .stream()
        .map(s -> new StudentResponseDto(
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getEmail()
        )).toList();
    }

    //update student
//    public StudentModel updateStudent(String id,StudentModel student){
//        StudentModel existingStudent=repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No Student found"));
//        existingStudent.setName(student.getName());
//        existingStudent.setAge(student.getAge());
//        existingStudent.setEmail(student.getEmail());
//        return repository.save(existingStudent);
//    }

    public StudentResponseDto updateStudent(String id, StudentRequestDto studentDto) {
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found with id: " + id));
        existingStudent.setName(studentDto.getName());
        existingStudent.setAge(studentDto.getAge());
        existingStudent.setEmail(studentDto.getEmail());
        StudentModel savedStudent = repository.save(existingStudent);
        return new StudentResponseDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getAge(),
                savedStudent.getEmail()
        );
    }

    //delete student
//    public void deleteStudent(String id){
//        repository.deleteById(id);
//    }

    public void deleteStudent(String id){
        StudentModel student = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Cannot delete: Student with ID " + id + " not found"));
        repository.delete(student);
    }
}
