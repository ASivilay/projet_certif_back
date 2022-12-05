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
import fr.m2i.Slackonslacertif.service.ChannelService;



@RestController
@RequestMapping(path="/channel")
public class ChannelController {

	@Autowired
	ChannelService channelService;
	
	// READ ALL
	@GetMapping(
			path="/bdd/channels",								
			produces={"application/json"} 						
	)
	public Iterable<Channel> getChannels() { 
	
		Iterable<Channel> channels = channelService.getChannels();
			
		return channels;
		
	}
	
	//READ ONE
	@GetMapping(path="/bdd/{id}")
	public Channel getChannel(@PathVariable Long id) {
		
		Optional<Channel> optChannel = channelService.getChannelById(id);
		Channel channel1 = optChannel.get();
		
		return channel1;
			
	}
	
	//CREATE et UPDATE
	@PostMapping(
			path="/bdd/post",								
			consumes={"application/json"} 						
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void saveChannel(@RequestBody Channel channel) { 
	
		channelService.saveChannel(channel);
		
	}
		
	//DELETE
	@DeleteMapping(
			path="/bdd/delete"							
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void deleteChannel(@RequestParam Long id) { 
	
		Optional<Channel> optChannel = channelService.getChannelById(id);
		Channel channel = optChannel.get();
		
		channelService.deleteChannelById(channel);
	}
	
	
	
	
}
