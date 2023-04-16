package hh.sof3as3.Movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Movie.domain.Director;
import hh.sof3as3.Movie.domain.DirectorRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DirectorRepositoryTest {

	@Autowired
	private DirectorRepository directorRepository;
	
	@Test
	public void findByDirectorLastNameReturnId() {
		List<Director> directors = directorRepository.findByLastName("Cameron");
		assertThat(directors.get(0).getDirectorId()).isEqualTo(1);
	}
	
	@Test
	public void createNewDirector() {
		Director director = new Director("Tim", "Burton");
		directorRepository.save(director);
		assertThat(director.getDirectorId()).isNotNull();
	}
	
	@Test
	public void deleteDirector() {
		directorRepository.delete(directorRepository.findByLastName("Cameron").get(0));
		List<Director> directors = directorRepository.findByLastName("Cameron");
		assertThat(directors).hasSize(0);
	}
	
}
