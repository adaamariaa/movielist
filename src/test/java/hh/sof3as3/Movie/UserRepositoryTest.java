package hh.sof3as3.Movie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Movie.domain.User;
import hh.sof3as3.Movie.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUsername() {
		User user = userRepository.findByUsername("admin.acc11");
		assertThat(user).isNotNull();
		assertThat(user.getRole()).isEqualTo("ADMIN");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("User234", "$2a$10$IK473eCDDKMQCWv2qunSCe0cYdwPr53HhpbzCFs1UucclO3bDhJZ.", "user.user@mail.com", "USER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteUser() {
		userRepository.delete(userRepository.findByUsername("admin.acc11"));
		User user = userRepository.findByUsername("admin.acc11");
		assertThat(user).isNull();
	}
}
