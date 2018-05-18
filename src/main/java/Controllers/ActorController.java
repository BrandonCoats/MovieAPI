package Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Models.Actor;
import Models.Movie;

import Repos.ActorsJPARepository;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
	//ArrayList<Actor> actors = new ArrayList<Actor>();
	@Autowired
	private ActorsJPARepository actorRepo;
	@RequestMapping(method=RequestMethod.POST)
	public void addActor(@RequestBody Actor act)
	{
		actorRepo.saveAndFlush(act);
	}
//	@RequestMapping(method=RequestMethod.POST)
//	public void addMovieToActor(@PathVariable int id,@RequestBody Movie mov)
//	{
//		Actor existing = retrieveActor(id);
//		existing.addMovie(mov);
//	}
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Actor retrieveActor(@PathVariable int id)
	{
		return actorRepo.findById(id).orElse(null);
	}
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public void deleteMovie(@PathVariable int id)
	{
		
		Actor existing = retrieveActor(id);
		if(existing !=null)
		{
			actorRepo.deleteById(id);
		}
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Actor> retrieveActors()
	{
		return actorRepo.findAll();
	}
}