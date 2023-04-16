package hh.sof3as3.Movie.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3as3.Movie.domain.DirectorRepository;
import hh.sof3as3.Movie.domain.GenreRepository;
import hh.sof3as3.Movie.domain.Movie;
import hh.sof3as3.Movie.domain.MovieRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	DirectorRepository directorRepository;

	@GetMapping("/movielist")
	public String getAllMovies(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "movieList";
	}

	@GetMapping(value = "/movies")
	public @ResponseBody List<Movie> movieListRest() {
		return (List<Movie>) movieRepository.findAll();
	}

	@GetMapping(value = "/movies/{id}")
	public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long movieId) {
		return movieRepository.findById(movieId);
	}

	@PostMapping(value = "/movies")
	public @ResponseBody Movie saveMovieRest(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}

	@GetMapping("/add-movie")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("genres", genreRepository.findAll());
		model.addAttribute("directors", directorRepository.findAll());
		return "addMovie";
	}

	
	
	@PostMapping("/save-movie")
	public String saveMovie(Movie movie) {
		movieRepository.save(movie);
		return "redirect:movielist";
	}

	@GetMapping("/delete-movie/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		movieRepository.deleteById(movieId);
		return "redirect:../movielist";
	}

	@GetMapping("/edit-movie/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editBook(@PathVariable("id") Long movieId, Model model) {
		model.addAttribute("movie", movieRepository.findById(movieId));
		model.addAttribute("genres", genreRepository.findAll());
		model.addAttribute("directors", directorRepository.findAll());
		return "editMovie";
	}

}
