package fr.m2i.slackonslacertif.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import fr.m2i.slackonslacertif.services.MessageService;

@CrossOrigin
@RestController
@RequestMapping(path="/api")
public class MessageRestController {

	@Autowired
	MessageService messageService;
	
	// READ ALL
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping(
			path="/message/listemessages",								
			produces={"application/json"} 						
	)
	public Iterable<Message> getMessages() { 
	
		Iterable<Message> messages = messageService.getAll();
			
		return messages;
		
	}
	
	//READ ONE
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping(path="/message/listemessages/trouver{id}")
	public Message getMessage(@RequestParam Long id) {
		
		Optional<Message> optMessage = messageService.getMessageById(id);
		Message message1 = optMessage.get();
		
		return message1;
			
	}
	
	//CREATE et UPDATE
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PostMapping(
			path="/message/listemessages/post",								
			consumes={"application/json"} 						
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void saveMessage(@RequestBody Message message) { 
	
		messageService.saveMessage(message);
		
		
	}
		
	//DELETE
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@DeleteMapping(
			path="/message/listemessages/delete"							
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void deleteMessage(@RequestParam Long id) { 
	
		Optional<Message> optMessage = messageService.getMessageById(id);
		Message message = optMessage.get();
		
		messageService.deleteMessage(message);
	}
	
	
	
	
}
