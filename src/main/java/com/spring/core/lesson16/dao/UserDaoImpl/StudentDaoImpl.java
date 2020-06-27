package com.spring.core.lesson16.dao.UserDaoImpl;

import com.spring.core.lesson16.domain.Student;
import com.spring.core.lesson16.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao<Student> {
    private static List<Student> students = new ArrayList<>();

    @Override
    public Student read(long id) throws Exception {
        Student student =  students.stream().filter(s->s.getId()==id).findFirst().orElse(null);
        if (student!=null){
            return student;
        }
        throw new Exception("There is no user with such id");
    }

    @Override
    public List<Student> readAll() {
        return students;
    }

    @Override
    public void create(Student student) {
        students.add(student);
    }

    @Override
    public void update(int id, String property, String newValue) throws Exception {
        Student student = read(id);
        if(student!=null){
            switch (property) {
                case "name":
                    student.setName(newValue);
                    break;
                case "age":
                    student.setAge(Integer.parseInt(newValue));
                    break;
                default:
                    throw new Exception("Incorrect input! Try again!");
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        Student student = read(id);
        if(student!=null){
            students.remove(student);
        }
    }
}
