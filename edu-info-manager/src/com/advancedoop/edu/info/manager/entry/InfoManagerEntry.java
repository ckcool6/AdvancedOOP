package com.advancedoop.edu.info.manager.entry;

import com.advancedoop.edu.info.manager.controller.OtherStudentController;
import com.advancedoop.edu.info.manager.controller.StudentController;
import com.advancedoop.edu.info.manager.controller.TeacherController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("--------欢迎来到信息管理系统--------");
            System.out.println("请输入选择：1.学生管理  2.老师管理  3.退出");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    //System.out.println("学生");
                   /* OtherStudentController otherStudentController = new OtherStudentController();
                    otherStudentController.start();*/
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    //System.out.println("老师");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("感谢使用");
                    System.exit(0); //退出JVM虚拟机
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }
}
