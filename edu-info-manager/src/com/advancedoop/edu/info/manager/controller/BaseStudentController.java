package com.advancedoop.edu.info.manager.controller;

import com.advancedoop.edu.info.manager.domain.Student;
import com.advancedoop.edu.info.manager.service.StudentService;

import java.util.Scanner;

public abstract class BaseStudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public final void start() {
        studentloop:
        while (true) {
            System.out.println("--------欢迎来到信息管理系统--------");
            System.out.println("请输入选择：1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            //Scanner sc = new Scanner(System.in);

            String choice = sc.next();

            switch (choice) {
                case "1":
                    //System.out.println("添加");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("删除");
                    deleteStudentById();
                    break;
                case "3":
                    //System.out.println("修改");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("查看");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("退出");
                    break studentloop;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }

    public final void updateStudent() {

        String updateId = inputStudentId();

        Student newStu = inputStudentInfo(updateId);

        studentService.updateStudent(updateId, newStu);
        System.out.println("修改成功！");

    }

    public final void deleteStudentById() {

        String delId = inputStudentId();
        studentService.deleteStudentById(delId);
        System.out.println("删除成功");
    }

    public final void addStudent() {

        String id;

        //Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生ID：");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("学号已被占用，请重新输入");
            } else {
                break;
            }
        }

        Student stu = inputStudentInfo(id);

        boolean result = studentService.addStudent(stu);
        if (result) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败");
        }
    }

    public final String inputStudentId() {
        String id;

        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("您输入的ID不存在，请重新输入：");
            } else {
                break;
            }
        }
        return id;
    }

    public final void findAllStudent() {

        Student[] stus = studentService.findAllStudent();

        if (stus == null) {
            System.out.println("查无信息，请添加后重试。");
            return;
        }

        System.out.println("学号\t\t姓名\t\t年龄\t\t生日");

        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    public abstract Student inputStudentInfo(String id);

}
