package com.example.notification1.service;

import com.example.notification1.entity.Student;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    List<Student> students = Arrays.asList(
            new Student("1", "Giada", "Dall'Ara", "giadadallara00@gmail.com"),
            new Student("2", "Paul", "Cezanne", "paul.cezanne@gmail.com"),
            new Student("3", "Giovanni", "Verga", "giovanni.verga@gmail.com"),
            new Student("4", "Oscar", "Wilde", "oscar.wilde@gmail.com")
    );


    public Student getStudentById(String contactId) {
        Optional<Student> studentFromList = students.stream().filter(students -> students.getId().equals(contactId)).findAny();
        if (studentFromList.isPresent()){
            return studentFromList.get();
        }
        return null;
    }
}
