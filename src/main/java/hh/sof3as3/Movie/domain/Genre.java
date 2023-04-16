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
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long genreId;
	public String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	@JsonIgnoreProperties ("genre")
	private List <Movie> movies;

	public Genre(Long genreId, String name) {
		super();
		this.genreId = genreId;
		this.name = name;
	}
	
	

	public Genre(String name) {
		super();
		this.name = name;
	}



	public Genre() {
		super();
	}


	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}



	@Override
	public String toString() {
		return "genreId=" + genreId + ", name=" + name + "]";
	}


}
