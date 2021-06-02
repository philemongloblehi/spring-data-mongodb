package com.mongodb.springdata;

import com.mongodb.springdata.Utils.Enums.Gender;
import com.mongodb.springdata.model.Address;
import com.mongodb.springdata.model.Student;
import com.mongodb.springdata.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			StudentRepository studentRepository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
					"Ivory Coast",
					"Abidjan",
					"BP 1069"
			);
			String email = "philemon.globlehi@gmail.com";

			Student student = new Student(
					"Philémon",
					"Globléhi",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science", "Maths"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));

			List<Student> students = mongoTemplate.find(query, Student.class);
			if (1 < students.size()) {
				throw new IllegalStateException("found many students with email " + email);
			}

			if (students.isEmpty()) {
				System.out.println("Inserting student " + student);
				studentRepository.insert(student);
			} else {
				System.out.println("Student already exists");
			}

		};
	}

}
