package fr.m2i.slackonslacertif;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.models.User;
import fr.m2i.slackonslacertif.services.ChannelService;
import fr.m2i.slackonslacertif.services.UserService;

@SpringBootApplication
public class SlackonslaCertifApplication implements CommandLineRunner {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	ChannelService channelservice;

	public static void main(String[] args) {
		SpringApplication.run(SlackonslaCertifApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		
						
	}

}
