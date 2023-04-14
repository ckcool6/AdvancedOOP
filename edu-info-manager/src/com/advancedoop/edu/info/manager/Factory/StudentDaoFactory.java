package com.advancedoop.edu.info.manager.Factory;

import com.advancedoop.edu.info.manager.dao.BaseStudentDao;
import com.advancedoop.edu.info.manager.dao.StudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new StudentDao();
    }
}
