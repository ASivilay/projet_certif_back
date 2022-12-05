package fr.m2i.Slackonslacertif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.m2i.Slackonslacertif.model.Channel;



@Repository
public interface ChannelRepository  extends JpaRepository<Channel, Long> {
	
}
