package Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Models.Movie;
import Models.Poster;
import Repos.MoviesJPARepository;
import Repos.PosterRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	private MoviesJPARepository movieRepo;
	@Autowired
	private PosterRepository posterRepo;
	
	@RequestMapping(path="/poster/{id}",method=RequestMethod.POST)
	public void addPosterForMovie(@RequestBody Poster pos,@PathVariable int id)
	{
		Movie mov = retrieveMovie(id);
		pos.setId(mov.getPosterId());
		posterRepo.save(pos);
	}
	@RequestMapping(path="/poster/{id}",method=RequestMethod.GET)
	@Transactional
	public Poster retrievePoster(@PathVariable int id)
	{
		return posterRepo.findById(id).orElse(null);
	}
	@RequestMapping(method=RequestMethod.POST)
	public void addMovie(@RequestBody Movie mov)
	{
		movieRepo.saveAndFlush(mov);
	}
	@RequestMapping(method=RequestMethod.PUT)
	@Transactional
	public void updateMovie(@RequestBody Movie mov)
	{
		
		
		Movie existing = retrieveMovie(mov.getId());
		if(existing == null)
		{
			throw new IllegalArgumentException("No Existing Movie");
		}
		existing.copy(mov);
		movieRepo.saveAndFlush(existing);

	}
//	public void addActorToMovie(@PathVariable int id,@RequestBody Actor act)
//	{
//		Movie existing = retrieveMovie(id);
//		existing.addActor(act);
//	}
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	@Transactional
	public void deleteMovie(@PathVariable int id)
	{
		Movie existing = retrieveMovie(id);
		if(existing != null) {
			movieRepo.deleteById(id);
		}
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	@Transactional
	public Movie retrieveMovie(@PathVariable int id)
	{
		return movieRepo.findById(id).orElse(null);
	}
	@RequestMapping(path="/searchByName", method=RequestMethod.GET)
	public List<Movie> findMovieByName(@PathVariable String name)
	{
		List<Movie> results = movieRepo.findByTitleLike(name);
		return results;
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Movie> retrieveMovies()
	{
		return movieRepo.findAll();
	}
}
