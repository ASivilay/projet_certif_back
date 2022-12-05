package fr.m2i.slackonslacertif.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.repository.ChannelRepository;


@Service
public class ChannelService {
		
		@Autowired 
		ChannelRepository csr;
		
		
		public List<Channel> getAll(){
			
			return csr.findAll();
		}
		
		public void saveChannel(Channel channel) {
		
		if(csr.existsById(channel.getId())) {
			csr.save(channel);
		}
		
		else if (channel.isModification()==true) {
			csr.save(channel);
		}

	}

		public void deleteChannel(Channel channel) {	
			
			if(channel.isModification()==true) {
				csr.deleteById(channel.getId());
			}
		}
		

		
		public void StringChannel(Channel channel) {
			
			csr.toString();
		}
		
		public String setMessageAjout (Channel channel) {
			return "Vous avez bien ajouté "+ channel.getName() + ".";
		}

		public String setMessageDelete(Channel channel) {
			return "Vous avez bien supprimé "+ channel.getName() + ".";
		}



}

