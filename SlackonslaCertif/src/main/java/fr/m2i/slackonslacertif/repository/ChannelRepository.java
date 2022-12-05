package fr.m2i.slackonslacertif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.m2i.slackonslacertif.models.Channel;

@Repository
public interface ChannelRepository  extends JpaRepository<Channel, Long> {
	
}
