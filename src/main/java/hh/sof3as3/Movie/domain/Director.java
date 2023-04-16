package hh.sof3as3.Movie.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long directorId;
	public String firstName;
	public String lastName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "director")
	@JsonIgnoreProperties ("director")
	private List <Movie> movies;

	public Director(Long directorId, String firstName, String lastName) {
		super();
		this.directorId = directorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	public Director(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public Director() {
		super();
	}



	public Long getDirectorId() {
		return directorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}



	@Override
	public String toString() {
		return "directorId=" + directorId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
		
}
