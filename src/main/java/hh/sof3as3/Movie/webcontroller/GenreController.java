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
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3as3.Movie.domain.Genre;
import hh.sof3as3.Movie.domain.GenreRepository;


@Controller
public class GenreController {

	@Autowired
	public GenreRepository genreRepository;
	
	@GetMapping("/genrelist")
	public String getAllGenres(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		return "genreList";
	}
	
	@GetMapping("/delete-genre/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteGenre(@PathVariable("id") Long genreId, Model model) {
		genreRepository.deleteById(genreId);
		return "redirect:../genrelist";
	}
	
	@GetMapping("/genres/{id}")
    public @ResponseBody Optional<Genre> findGenreRest(@PathVariable("id") Long genreId) {	
    	return genreRepository.findById(genreId);
    }      
	
	@GetMapping("/genres")
	public @ResponseBody List<Genre> genreListRest() {
		return (List<Genre>) genreRepository.findAll();
	}

	@GetMapping("/genrelist/{id}")
	public String findGenre(@PathVariable("id") Long genreId, Model model) {
		Optional<Genre> genreOptional = genreRepository.findById(genreId);
		Genre genre = genreOptional.get();
		model.addAttribute("genre", genre);
		model.addAttribute("movies", genreOptional.get().getMovies());
		return "moviesOfGenre";
	}
	
	@GetMapping("/add-genre")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addGenre(Model model){
	 model.addAttribute("genre", new Genre());
	 return "addGenre";
	}
	
	@PostMapping("/save-genre")
	public String saveGenre(Genre genre){
	 genreRepository.save(genre);
	 return "redirect:genrelist";
	}
	
	@GetMapping("/edit-genre/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editGenre(@PathVariable("id") Long genreId, Model model) {
		model.addAttribute("genre", genreRepository.findById(genreId));
		return "editGenre";
	}
	
}
