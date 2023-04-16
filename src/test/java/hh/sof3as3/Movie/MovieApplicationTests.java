package hh.sof3as3.Movie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3as3.Movie.webcontroller.DirectorController;
import hh.sof3as3.Movie.webcontroller.GenreController;
import hh.sof3as3.Movie.webcontroller.MovieController;

@SpringBootTest
class MovieApplicationTests {

	@Autowired
	private MovieController movieController;
	
	@Autowired
	private DirectorController directorController;
	
	@Autowired
	private GenreController genreController;
	
	@Test
	void movieContextLoads() {
		assertThat(movieController).isNotNull();
	}
	
	@Test
	void genreContextLoads() {
		assertThat(genreController).isNotNull();
	}

	@Test
	void directorContextLoads() {
		assertThat(directorController).isNotNull();
	}
	
}
