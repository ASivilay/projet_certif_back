package fr.m2i.slackonslacertif.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.slackonslacertif.models.Message;
import fr.m2i.slackonslacertif.repository.MessageRepository;


@Service
public class MessageService {
		
		@Autowired 
		MessageRepository msr;
		
		
		public List<Message> getAll(){
			
			return msr.findAll();
		}
		
		public void saveMessage(Message message) {
			msr.save(message);

	}

		public void deleteMessage(Message message) {	
			
				msr.delete(message);
			}
		

		
		public void StringMessage(Message message) {
			
			msr.toString();
		}
		
		public String setMessageAjout (Message message) {
			return "Vous avez bien ajouté "+ message.getContent()+ " de " + message.getUsername() + "." ;
		}

		public String setMessageDelete(Message message) {
			return "Vous avez bien supprimé "+ message.getContent() + " de " + message.getUsername() + "." ;
		}



}

