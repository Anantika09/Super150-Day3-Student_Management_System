package com.example.day3_studentmanagementsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/")
    public String hello(){
        return "hii,how are you?";
    }
}
