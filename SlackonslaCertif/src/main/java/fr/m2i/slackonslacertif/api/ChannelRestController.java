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

import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.services.ChannelService;


@RestController
@RequestMapping(path="/api")
public class ChannelRestController {

	@Autowired
	ChannelService channelService;
	
	// READ ALL
	@GetMapping(
			path="/canalgeneral/listecanal",								
			produces={"application/json"} 						
	)
	public Iterable<Channel> getChannels() { 
	
		Iterable<Channel> channels = channelService.getAll();
			
		return channels;
		
	}
	
	//READ ONE
	@GetMapping(path="/canalgeneral/listecanal/trouver{id}",
			    produces={"application/json"} 	
    )
	@ResponseStatus(code=HttpStatus.FOUND)
	public Channel getChannel(@RequestParam Long id) {
		
		Optional<Channel> optChannel = channelService.getChannelById(id);
		Channel channel1 = optChannel.get();
		
		return channel1;
			
	}
	
	//CREATE et UPDATE
	@PostMapping(
			path="/canalgeneral/listecanal/post",								
			consumes={"application/json"} 						
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void saveChannel(@RequestBody Channel channel) { 
	
		channelService.saveChannel(channel);
		
	}
		
	//DELETE
	@DeleteMapping(
			path="/canalgeneral/listecanal/delete"							
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void deleteChannel(@RequestParam Long id) { 
	
		Optional<Channel> optChannel = channelService.getChannelById(id);
		Channel channel = optChannel.get();
		
		channelService.deleteChannel(channel);
	}
	
	
	
	
}
