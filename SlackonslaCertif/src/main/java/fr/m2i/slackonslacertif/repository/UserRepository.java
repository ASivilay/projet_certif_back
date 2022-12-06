package fr.m2i.slackonslacertif.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	
	import fr.m2i.slackonslacertif.models.User;

	@Repository
	public interface UserRepository extends JpaRepository<User, Long> {
		
	}


