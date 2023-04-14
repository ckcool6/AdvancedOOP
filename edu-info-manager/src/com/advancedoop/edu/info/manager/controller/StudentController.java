package com.advancedoop.edu.info.manager.controller;

import com.advancedoop.edu.info.manager.domain.Student;

import java.util.Scanner;

public class StudentController extends BaseStudentController {
    private Scanner sc = new Scanner(System.in);
    @Override
    public Student inputStudentInfo(String id) {

        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        String age = sc.next();
        System.out.println("请输入学生生日：");
        String birthday = sc.next();

        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}
