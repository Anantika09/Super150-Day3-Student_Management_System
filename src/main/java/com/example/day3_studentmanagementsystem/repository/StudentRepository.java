package com.example.day3_studentmanagementsystem.repository;

import com.example.day3_studentmanagementsystem.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel,String> {
}
