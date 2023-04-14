package com.advancedoop.edu.info.manager.dao;

import com.advancedoop.edu.info.manager.domain.Student;

public class StudentDao implements BaseStudentDao{
    private static Student[] stus = new Student[5];

    static {
        Student stu1 = new Student("hj001","lisi","13","1999-1-1");
        Student stu2 = new Student("hj002","Zhang san","13","1989-1-2");

        stus[0] = stu1;
        stus[1] = stu2;
    }
    @Override
    public Student[] findAllStudent() {
        return stus;
    }
    @Override
    public boolean addStudent(Student stu) {
        //Student[] stus = new Student[5];
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        } else {
            stus[index] = stu;
            return true;
        }
    }
    @Override
    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
        stus[index] = null;
    }
    @Override
    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
    @Override
    public void updateStudent(String updateId, Student newStu) {
        int index = getIndex(updateId);
        stus[index] = newStu;
    }
}
