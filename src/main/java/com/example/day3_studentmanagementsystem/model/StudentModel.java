package com.example.day3_studentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Students")
public class StudentModel {
    @Id
    private String id;
    private String name;
    private int age;
    private String email;
}
