package fr.m2i.Slackonslacertif.controller;


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


import fr.m2i.Slackonslacertif.model.Channel;
import fr.m2i.Slackonslacertif.model.Message;
import fr.m2i.Slackonslacertif.service.ChannelService;
import fr.m2i.Slackonslacertif.service.MessageService;



@RestController
@RequestMapping(path="/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	// READ ALL
	@GetMapping(
			path="/bdd/messages",								
			produces={"application/json"} 						
	)
	public Iterable<Message> getMessagess() { 
	
		Iterable<Message> messages = messageService.getMessages();
			
		return messages;
		
	}
	
	//READ ONE
	@GetMapping(path="/bdd/{id}")
	public Message getMessage(@PathVariable Long id) {
		
		Optional<Message> optMessage = messageService.getMessageById(id);
		Message message1 = optMessage.get();
		
		return message1;
			
	}
	
	//CREATE et UPDATE
	@PostMapping(
			path="/bdd/post",								
			consumes={"application/json"} 						
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void saveMessage(@RequestBody Message message) { 
	
		messageService.saveMessage(message);
		
	}
		
	//DELETE
	@DeleteMapping(
			path="/bdd/delete"							
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void deleteMessage(@RequestParam Long id) { 
	
		Optional<Message> optMessage = messageService.getMessageById(id);
		Message message = optMessage.get();
		
		messageService.deleteMessageById(message.getId());
	}
	
	
	
	
}
