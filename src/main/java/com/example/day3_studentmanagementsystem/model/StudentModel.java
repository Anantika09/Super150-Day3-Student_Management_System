package com.example.day3_studentmanagementsystem.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
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
