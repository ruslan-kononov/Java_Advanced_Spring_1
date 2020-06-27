package com.spring.core.lesson16;

import com.spring.core.lesson16.dao.StudentDao;
import com.spring.core.lesson16.dao.UserDaoImpl.StudentDaoImpl;
import com.spring.core.lesson16.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StudentConfiguration {
    @Bean(name = "studentDaoImpl")
    public StudentDao getStudentDao() {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao;
    }

    @Bean(name = "student1")
    public Student getStudent() {
        Student student = new Student(1,"Alec Bolder",20);
        return student;
    }

    @Bean(name = "student2")
    public Student getStudent2() {
        Student student = new Student(2,"Alice Wonderland",20);
        return student;
    }

}
