package hh.sof3as3.Movie.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String name;
	public double duration;
	
	@ManyToOne
	@JsonIgnoreProperties ("movies")
	@JoinColumn(name= "directorId")
	private Director director;
	
	@ManyToOne
	@JsonIgnoreProperties ("movies")
	@JoinColumn(name= "genreId")
	private Genre genre;
	
	public Movie(String name, double duration, Director director, Genre genre) {
		super();
		this.name = name;
		this.duration = duration;
		this.director = director;
		this.genre = genre;
	}
	
	public Movie(Long id, String name, double duration, Director director, Genre genre) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.director = director;
		this.genre = genre;
	}
	

	public Movie() {
		super();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}


	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", duration=" + duration + "]";
	}



}
