package com.example.notification1.controller;

import com.example.notification1.DTO.NotificationDTO;
import com.example.notification1.entity.Student;
import com.example.notification1.service.EmailService;
import com.example.notification1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    StudentService studentService;

    @Autowired
    EmailService emailService;

    @PostMapping("/notification")
    public ResponseEntity sendNotification(@RequestBody NotificationDTO payload){
        try {
            Student studentToSendNotification = studentService.getStudentById(payload.getContactId());
            if (studentToSendNotification == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The student not found");
            }
            emailService.sendTo(studentToSendNotification.getEmail(), payload.getTitle(), payload.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            System.err.println("Error in notification controller: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
