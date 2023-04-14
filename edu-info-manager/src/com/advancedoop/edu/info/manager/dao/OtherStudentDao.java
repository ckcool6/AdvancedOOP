package com.advancedoop.edu.info.manager.dao;

import com.advancedoop.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao implements BaseStudentDao {
    private static ArrayList<Student> stus = new ArrayList<>();

    static {
        Student stu1 = new Student("hj001","lisi","13","1999-1-1");
        Student stu2 = new Student("hj002","Zhang san","13","1989-1-2");

        stus.add(stu1);
        stus.add(stu2);
    }
    @Override
    public Student[] findAllStudent() {
        Student[] students = new Student[stus.size()];
        for (int i = 0; i < students.length; i++) {
            students[i] = stus.get(i);
        }
        return students;
    }
    @Override
    public boolean addStudent(Student stu) {
      stus.add(stu);
      return true;
    }
    @Override
    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
        stus.remove(index);
    }
    @Override
    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
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
        stus.set(index,newStu);
    }
}
