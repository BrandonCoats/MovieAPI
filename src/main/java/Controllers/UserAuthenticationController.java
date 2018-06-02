package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import Models.User;
import Repos.UserJPARepository;

@RestController
@RequestMapping("/api/registration")
public class UserAuthenticationController {

	@Autowired
	private UserJPARepository userRepo;
	
	@RequestMapping(method=RequestMethod.POST)
	private void createUser(
			@RequestBody User user) {
		
		userRepo.saveAndFlush(user);
	}
}