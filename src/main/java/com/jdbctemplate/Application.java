package com.jdbctemplate;

import com.jdbctemplate.dao.DAO;
import com.jdbctemplate.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

	private static DAO<Course> dao;

	public Application(DAO<Course> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		System.out.println("Create course-------------------------\n");
		Course springVue = new Course("Spring Boot", "New Course", "google.com");
		dao.create(springVue);

		System.out.println("\nget one  course-------------------------\n");
		Optional<Course> firstOne = dao.get(1);
		System.out.println(firstOne.get());

		springVue.setDescription("sdsdsdsd");
		dao.update(springVue,6);

		dao.delete(4);



		System.out.println("all Courses-------------------------\n");
		List<Course> courses = dao.list();
		courses.forEach(System.out::println);
	}

}
