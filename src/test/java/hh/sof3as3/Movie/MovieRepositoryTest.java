package hh.sof3as3.Movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Movie.domain.DirectorRepository;
import hh.sof3as3.Movie.domain.GenreRepository;
import hh.sof3as3.Movie.domain.Movie;
import hh.sof3as3.Movie.domain.MovieRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MovieRepositoryTest {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private DirectorRepository directorRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	
	@Test
	public void findByMovieNameReturnDuration() {
		List<Movie> movies = movieRepository.findByName("Titanic");
		assertThat(movies.get(0).getDuration()).isEqualTo(103);
	}
	
	@Test
	public void createNewMovie() {
		Movie movie = new Movie("Stuck in love", 96, directorRepository.findByLastName("Boone").get(0), genreRepository.findByName("Romantic").get(0));
		movieRepository.save(movie);
		assertThat(movie.getId()).isNotNull();
	}
	
	@Test
	public void deleteMovie() {
		movieRepository.delete(movieRepository.findByName("Titanic").get(0));
		List<Movie> movies = movieRepository.findByName("Titanic");
		assertThat(movies).hasSize(0);
	}
}
