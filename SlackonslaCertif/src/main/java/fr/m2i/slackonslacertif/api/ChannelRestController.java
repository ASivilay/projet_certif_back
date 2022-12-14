package fr.m2i.slackonslacertif.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.services.ChannelService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/api")

public class ChannelRestController {

	@Autowired
	ChannelService channelService;
	

	// READ ALL
	
	@GetMapping(
			path="/canalgeneral/listecanaux",								
			produces={"application/json"} 						
	)
	public Iterable<Channel> getChannels() { 
	
		Iterable<Channel> channels = channelService.getAll();
			
		return channels;	
	}
	
	//READ ONE
	@GetMapping(path="/canalgeneral/listecanaux/trouver{id}",
			    produces={"application/json"} 	
    )
	public Channel getChannel(@RequestParam Long id) {
		
		Optional<Channel> optChannel = channelService.getChannelById(id);
		Channel channel1 = optChannel.get();
		
		return channel1;		
	}
	
	//CREATE et UPDATE
	@PostMapping(
			path="/canalgeneral/listecanaux/post",								
			consumes={"application/json"} 						
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void saveChannel(@RequestBody Channel channel) { 
	
		channelService.saveChannel(channel);	
	}
	
	@PatchMapping(
			path="/canalgeneral/listecanaux/patch",								
			consumes={"application/json"} 						
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void updateChannel(@RequestBody Channel channel) { 
	
		channelService.updateChannel(channel);	
	}
		
	//DELETE

	@DeleteMapping(
			path="/canalgeneral/listecanaux/delete"							
	)
	@ResponseStatus(code=HttpStatus.CREATED)	
	public void deleteChannel(@RequestParam Long id) { 
	
		Optional<Channel> optChannel = channelService.getChannelById(id);
		Channel channel = optChannel.get();
		
		channelService.deleteChannel(channel);
	}
	
	
}
