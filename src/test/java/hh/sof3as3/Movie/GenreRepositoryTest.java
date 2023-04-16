package hh.sof3as3.Movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Movie.domain.Genre;
import hh.sof3as3.Movie.domain.GenreRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GenreRepositoryTest {


		@Autowired
		private GenreRepository genreRepository;
		
		@Test
		public void findByGenreLastNameReturnId() {
			List<Genre> genres = genreRepository.findByName("Drama");
			assertThat(genres.get(0).getGenreId()).isEqualTo(2);
		}
		
		@Test
		public void createNewGenre() {
			Genre genre = new Genre("Fantasy");
			genreRepository.save(genre);
			assertThat(genre.getGenreId()).isNotNull();
		}
		
		@Test
		public void deleteGenre() {
			genreRepository.delete(genreRepository.findByName("Romantic").get(0));
			List<Genre> genres = genreRepository.findByName("Romantic");
			assertThat(genres).hasSize(0);
		}
		
	}


