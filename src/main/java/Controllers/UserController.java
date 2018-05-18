package Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Models.User;

import Repos.UserJPARepository;


@RestController
@RequestMapping("/api/users")
public class UserController {
	//ArrayList<User> users = new ArrayList<User>();
	@Autowired
	private UserJPARepository userRepo;
	@RequestMapping(method=RequestMethod.POST)
	public void addUser(@RequestBody User user)
	{
		userRepo.saveAndFlush(user);
	}
	@RequestMapping(method=RequestMethod.PUT)
	public void updateUser(@RequestBody User user)
	{
		User existing = userRepo.findById(user.getId()).orElse(null);
		if(existing == null)
		{
			throw new IllegalArgumentException("No Existing user");
		}
		existing.copy(user);
		userRepo.saveAndFlush(existing);
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id)
	{
		User existing = retrieveUser(id);
		if(existing !=null)
		{
			userRepo.deleteById(id);
		}
	}
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public User retrieveUser(@PathVariable int id)
	{
		return userRepo.findById(id).orElse(null);
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<User> retrieveUsers(@RequestParam(required=false) Boolean sort)
	{
		if(sort == null) {
			return userRepo.findAll();
		}
		
		return userRepo.findAll();
	}
}
