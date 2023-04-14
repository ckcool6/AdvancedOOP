package com.advancedoop.edu.info.manager.controller;

import com.advancedoop.edu.info.manager.domain.Teacher;
import com.advancedoop.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {

    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();


    public void start() {

        //Scanner sc = new Scanner(System.in);

        teacherloop:
        while (true) {
            System.out.println("---------欢迎来到<老师>管理系统--------");
            System.out.println("请输入您的选择：1.添加老师 2.删除老师 3.修改老师 4.查看老师 5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    //System.out.println("add");
                    addTeacher();
                    break;
                case "2":
                    //System.out.println("delete");
                    deleteTeacherById();
                    break;
                case "3":
                    //System.out.println("update");
                    updateTeacher();
                    break;
                case "4":
                    //System.out.println("view");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢使用老师管理系统");
                    break teacherloop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }

    }

    public void deleteTeacherById() {
        String id = inputTeacherId();
        teacherService.deleteTeacherById(id);
        System.out.println("删除成功");
    }

    public void findAllTeacher() {
        Teacher[] teachers = teacherService.findAllTeacher();
        if (teachers == null) {
            System.out.println("查无信息，请添加后重试");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t生日");
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null) {
                System.out.println(t.getId() + "\t" + t.getName() + "\t" + t.getAge() + "\t\t" + t.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("请输入老师id：");
            id = sc.next();
            boolean exists = teacherService.isExists(id);

            if (exists) {
                System.out.println("id已被占用，请重新输入:");
            } else {
                break;
            }
        }

        Teacher t = inputTeacherInfo(id);

        boolean result = teacherService.addTeacher(t);

        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public void updateTeacher() {

        String id = inputTeacherId();

        Teacher newTeacher = inputTeacherInfo(id);

        teacherService.updateTeacher(id, newTeacher);
        System.out.println("修改成功");

    }

    public String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("请输入id");
            id = sc.next();

            boolean exists = teacherService.isExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在");
            } else {
                break;
            }
        }
        return id;
    }

    public Teacher inputTeacherInfo(String id) {
        System.out.println("请输入老师的姓名：");
        String name = sc.next();
        System.out.println("请输入老师的年龄：");
        String age = sc.next();
        System.out.println("请输入老师的生日：");
        String birthday = sc.next();

        Teacher t = new Teacher();
        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setBirthday(birthday);

        return t;
    }
}
