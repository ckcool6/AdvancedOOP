package com.advancedoop.edu.info.manager.service;

import com.advancedoop.edu.info.manager.Factory.StudentDaoFactory;
import com.advancedoop.edu.info.manager.dao.BaseStudentDao;
import com.advancedoop.edu.info.manager.dao.OtherStudentDao;
import com.advancedoop.edu.info.manager.dao.StudentDao;
import com.advancedoop.edu.info.manager.domain.Student;

public class StudentService {
    private BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();

    public boolean addStudent(Student stu) {
        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {

        Student[] stus = studentDao.findAllStudent();

        boolean exists = false; //假设id不存在
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        Student[] allStudent = studentDao.findAllStudent();
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if (stu != null) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return allStudent;
        } else {
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newStu) {
        studentDao.updateStudent(updateId,newStu);
    }
}
