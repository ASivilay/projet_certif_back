package fr.m2i.Slackonslacertif.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.Slackonslacertif.model.Channel;
import fr.m2i.Slackonslacertif.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepository;
	
	public Iterable<Channel> getChannels() {
		
		Iterable<Channel> channels = channelRepository.findAll();
		
		return channels;
	}
	
	public Optional<Channel> getChannelById(Long id) {
		
		return channelRepository.findById(id);
	}
		
     public String saveChannel(Channel channel) {
        
        if(channelRepository.existsById(channel.getId()) && channel.isModification()==true) {
        	channelRepository.save(channel);
            return "Vous avez bien ajouté "+ channel.getName() + ".";
        }
        
        else
            return "Vous ne pouvez pas ajouter "+ channel.getName() + ".";
    }
	
		
	public String deleteChannelById(Channel channel) {    
         
         if(channel.isModification()==true) {
        	 channelRepository.deleteById(channel.getId());
             
             return "Vous avez bien supprimé "+ channel.getName() + ".";
         }
         else
             return "Vous ne pouvez pas supprimer "+ channel.getName() + ".";
     }
	
	
}
