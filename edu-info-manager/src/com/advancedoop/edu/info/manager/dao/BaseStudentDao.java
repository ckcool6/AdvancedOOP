package com.advancedoop.edu.info.manager.dao;

import com.advancedoop.edu.info.manager.domain.Student;

public interface BaseStudentDao {

    public abstract Student[] findAllStudent();

    public abstract boolean addStudent(Student stu);

    public abstract void deleteStudentById(String delId);

    public abstract int getIndex(String id);

    public abstract void updateStudent(String updateId, Student newStu);
}