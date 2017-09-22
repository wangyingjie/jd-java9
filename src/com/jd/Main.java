package com.jd;

import com.jd.stu.StudentService;
import com.jd.stu.impl.StudentServiceImpl;

public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();

        studentService.getStudent1();
        studentService.getStudent2();

        System.out.println("Hello World!");
    }
}
