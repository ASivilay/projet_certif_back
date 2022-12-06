package fr.m2i.slackonslacertif.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.models.Message;
import fr.m2i.slackonslacertif.models.User;
import fr.m2i.slackonslacertif.repository.ChannelRepository;
import fr.m2i.slackonslacertif.repository.UserRepository;


@Service
public class UserService {
		
		@Autowired 
		UserRepository usr;
		
		
		public Iterable<User> getAll(){
						
			return usr.findAll();
		}
		
		public Optional<User> getUserById(Long id) {
			
			return usr.findById(id);
		}
		
		public void saveUser(User user) {
			usr.save(user);

		}

		public void deleteUser(User user) {
			
			usr.deleteById(user.getId());
		}
				
		public void StringUser(User user) {
			
			usr.toString();
		}
		
		
		



}

