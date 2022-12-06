package fr.m2i.slackonslacertif.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.slackonslacertif.models.Message;
import fr.m2i.slackonslacertif.models.User;
import fr.m2i.slackonslacertif.services.MessageService;
import fr.m2i.slackonslacertif.services.UserService;


@RestController
@RequestMapping(path="/api")
public class UserRestController {

	@Autowired
	UserService userService;
	
	// READ ALL
	@GetMapping(
			path="/user/listeusers",								
			produces={"application/json"} 						
	)
	public Iterable<User> getUsers() { 
	
		Iterable<User> users = userService.getAll();
			
		return users;
		
	}
	
	//READ ONE
	@GetMapping(path="/user/listeusers/trouver{id}")
	public User getUser(@RequestParam Long id) {
		
		Optional<User> optUser = userService.getUserById(id);
		User user1 = optUser.get();
		
		return user1;
			
	}
	
	//CREATE et UPDATE
	@PostMapping(
			path="/user/listeusers/post",								
			consumes={"application/json"} 						
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void saveUser(@RequestBody User user) { 
	
		userService.saveUser(user);
		
		
	}
		
	//DELETE
	@DeleteMapping(
			path="/user/listeusers/delete"							
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void deleteUser(@RequestParam Long id) { 
	
		Optional<User> optUser = userService.getUserById(id);
		User user = optUser.get();
		
		userService.deleteUser(user);
	}
	
	
	
	
}
