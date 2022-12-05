package fr.m2i.Slackonslacertif;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.m2i.Slackonslacertif.model.Channel;
import fr.m2i.Slackonslacertif.service.ChannelService;

@SpringBootApplication
public class DebugSlackonslacertifApplication implements CommandLineRunner {
	
	@Autowired
	private ChannelService channelService;

	public static void main(String[] args) {
		SpringApplication.run(DebugSlackonslacertifApplication.class, args);
	}

	
	@Override
	@Transactional
	public void run(String... args) throws Exception {	
		
		
	}
}
