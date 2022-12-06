package fr.m2i.slackonslacertif.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.repository.ChannelRepository;


@Service
public class ChannelService {
		
		@Autowired 
		ChannelRepository csr;
		
		
		public Iterable<Channel> getAll(){
						
			return csr.findAll();
		}
		
		public Optional<Channel> getChannelById(Long id) {
			
			return csr.findById(id);
		}
		
		public String saveChannel(Channel channel) {
		
		if(csr.existsById(channel.getId()) && channel.isModification()==true) {
			csr.save(channel);
			return "Vous avez bien ajouté "+ channel.getName() + ".";
		}
		
		else
			return "Vous ne pouvez pas ajouter "+ channel.getName() + ".";
	}

		public String deleteChannel(Channel channel) {	
			
			if(channel.isModification()==true) {
				csr.deleteById(channel.getId());
				
				return "Vous avez bien supprimé "+ channel.getName() + ".";
			}
			else
				return "Vous ne pouvez pas supprimer "+ channel.getName() + ".";
		}
		

		public void StringChannel(Channel channel) {
			
			csr.toString();
		}
		



}

