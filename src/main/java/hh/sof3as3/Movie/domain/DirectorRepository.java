package hh.sof3as3.Movie.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DirectorRepository extends CrudRepository<Director, Long>{
	
	List <Director> findById(long directorId);
	List <Director> findByFirstName(String firstName);
	List <Director> findByLastName(String lastName);

	
}
