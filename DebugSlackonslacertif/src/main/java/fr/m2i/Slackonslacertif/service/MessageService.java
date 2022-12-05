package fr.m2i.Slackonslacertif.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.Slackonslacertif.model.Channel;
import fr.m2i.Slackonslacertif.model.Message;
import fr.m2i.Slackonslacertif.repository.ChannelRepository;
import fr.m2i.Slackonslacertif.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public Iterable<Message> getMessages() {
		
		Iterable<Message> messagess = messageRepository.findAll();
		
		return messagess;
	}
	
	public Optional<Message> getMessageById(Long id) {
		
		return messageRepository.findById(id);
	}
	
	public Message saveMessage(Message message) {
		return messageRepository.save(message);
	}
	
	public void deleteMessageById(Long id) {
			
		messageRepository.deleteById(id);
	}
	
	
	
	
}
