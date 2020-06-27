package com.spring.core.lesson16;

import com.spring.core.lesson16.dao.StudentDao;
import com.spring.core.lesson16.dao.UserDaoImpl.StudentDaoImpl;
import com.spring.core.lesson16.domain.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class,args);
		StudentDao studentDao = (StudentDaoImpl) ctx.getBean("studentDaoImpl");
		Student student1 = (Student) ctx.getBean("student1");
		Student student2 = (Student) ctx.getBean("student2");

		//create
		studentDao.create(student1);
		studentDao.create(student2);

		//read
		System.out.println(studentDao.read(2));
		System.out.println("================================");
		studentDao.readAll().forEach(System.out::println);
		System.out.println("================================");


		//update
		studentDao.update(2,"name", "Lara Smiths");
		System.out.println(studentDao.read(2));
		System.out.println("================================");


		//delete
		studentDao.delete(2);
		studentDao.readAll().forEach(System.out::println);
	}

}
