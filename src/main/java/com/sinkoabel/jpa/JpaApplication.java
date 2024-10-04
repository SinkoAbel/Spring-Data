package com.sinkoabel.jpa;

import com.github.javafaker.Faker;
import com.sinkoabel.jpa.models.Author;
import com.sinkoabel.jpa.models.Video;
import com.sinkoabel.jpa.repositories.AuthorRepository;
import com.sinkoabel.jpa.repositories.VidoRepository;
import com.sinkoabel.jpa.specifications.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
		AuthorRepository repository,
		VidoRepository videoRepository
	) {
		return args -> {
			// Seed the DB.
			/*for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();

				var author = Author.builder()
					.firstName(faker.name().firstName())
					.lastName(faker.name().lastName())
					.age(faker.number().numberBetween(19, 50))
					.email(faker.internet().emailAddress())
					.build();

				repository.save(author);
			}*/

			Specification<Author> spec = Specification
				.where(AuthorSpecification.hasAge(33))
				.and(AuthorSpecification.firstNameLike("Fra"));

			repository.findAll(spec).forEach(System.out::println);
		};
	}
}
