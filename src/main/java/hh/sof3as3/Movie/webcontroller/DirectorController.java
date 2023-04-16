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

import hh.sof3as3.Movie.domain.Director;
import hh.sof3as3.Movie.domain.DirectorRepository;


@Controller
public class DirectorController {
	
	@Autowired
	public DirectorRepository directorRepository;
	
	@GetMapping("/directorlist")
	public String getAllDirectors(Model model) {
		model.addAttribute("directors", directorRepository.findAll());
		return "directorList";
	}
	
	@GetMapping("/delete-director/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteDirector(@PathVariable("id") Long directorId, Model model) {
		directorRepository.deleteById(directorId);
		return "redirect:../directorlist";
	}
	
	@GetMapping("/directors/{id}")
    public @ResponseBody Optional<Director> findDirectorRest(@PathVariable("id") Long directorId) {	
    	return directorRepository.findById(directorId);
    }      
	
	
	@GetMapping("/directors")
	public @ResponseBody List<Director> directorListRest() {
		return (List<Director>) directorRepository.findAll();
	}
	
	@GetMapping("/directorlist/{id}")
	public String findDirector(@PathVariable("id") Long directorId, Model model) {
		Optional<Director> genreOptional = directorRepository.findById(directorId);
		Director director = genreOptional.get();
		model.addAttribute("director", director);
		model.addAttribute("movies", genreOptional.get().getMovies());
		return "moviesOfDirector";
	}

	
	@GetMapping("/add-director")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addDirector(Model model){
	 model.addAttribute("director", new Director());
	 return "addDirector";
	}
	
	@PostMapping("/save-director")
	public String save(Director director){
		directorRepository.save(director);
	 return "redirect:directorlist";
	}
	
	@GetMapping("/edit-director/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editDirector(@PathVariable("id") Long directorId, Model model) {
		model.addAttribute("director", directorRepository.findById(directorId));
		return "editDirector";
	}
}
