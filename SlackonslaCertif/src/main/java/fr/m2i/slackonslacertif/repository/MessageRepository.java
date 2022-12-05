package fr.m2i.slackonslacertif.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import fr.m2i.slackonslacertif.models.Message;

	@Repository
	public interface MessageRepository extends JpaRepository<Message, Long> {
		
	}


