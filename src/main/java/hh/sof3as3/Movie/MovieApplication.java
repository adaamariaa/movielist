package hh.sof3as3.Movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.sof3as3.Movie.domain.Director;
import hh.sof3as3.Movie.domain.DirectorRepository;
import hh.sof3as3.Movie.domain.Genre;
import hh.sof3as3.Movie.domain.GenreRepository;
import hh.sof3as3.Movie.domain.Movie;
import hh.sof3as3.Movie.domain.MovieRepository;
import hh.sof3as3.Movie.domain.User;
import hh.sof3as3.Movie.domain.UserRepository;

@SpringBootApplication
public class MovieApplication {

	private static final Logger log = LoggerFactory.getLogger(MovieApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	
	}
	
	@Bean
	public CommandLineRunner movieDemo(MovieRepository mRepository, DirectorRepository dRepository, GenreRepository gRepository, UserRepository urepository) { 
		return (args) -> {
		
		log.info("add few directors");
		Director director1 = new Director("James", "Cameron");
		Director director2 = new Director("Josh", "Boone");
		dRepository.save(director1);
		dRepository.save(director2);
		
		log.info("fetch all directors");
		for (Director director : dRepository.findAll()) {
			log.info(director.toString());
		}
		
		log.info("add few genres");
		Genre genre1 = new Genre("Romantic");
		Genre genre2 = new Genre("Drama");
		Genre genre3 = new Genre("Fiction");
		gRepository.save(genre1);
		gRepository.save(genre2);
		gRepository.save(genre3);
		
		log.info("fetch all genres");
		for (Genre genre : gRepository.findAll()) {
			log.info(genre.toString());
		}
		
		log.info("add few movies");
		Movie movie1 = new Movie("Titanic", 103, dRepository.findByLastName("Cameron").get(0), gRepository.findByName("Romantic").get(0));
		Movie movie2 = new Movie("Tähtiin kirjoitettu virhe", 120, dRepository.findByLastName("Boone").get(0), gRepository.findByName("Drama").get(0));
		Movie movie3 = new Movie("Avatar", 162, dRepository.findByLastName("Cameron").get(0), gRepository.findByName("Fiction").get(0));
		mRepository.save(movie1);
		mRepository.save(movie2);
		mRepository.save(movie3);
		
		log.info("fetch all movies");
		for (Movie movie : mRepository.findAll()) {
			log.info(movie.toString());
		}
		
		User user1 = new User("user.acc22", "$2a$10$WuKYiQEuwOb6YF.20Fg19.egHsD5wiAp4XfF18iWvcCi4KCNF/.bC", "user11@mail.com", "USER");
		User user2 = new User("admin.acc11", "$2a$10$mnXo1NKeyViNx14dFpF0KeE0OHUqE.ciwBMIb5kGDQOVWxz3f9OcS", "admin2@mail.fi", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
		};

	}
	}
