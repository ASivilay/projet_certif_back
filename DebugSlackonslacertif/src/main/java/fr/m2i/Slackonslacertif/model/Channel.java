package fr.m2i.Slackonslacertif.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="channel")

public class Channel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(nullable = false, length = 20, name ="name")
		private String name;
			
		@Column(nullable = false, name ="modification")
		private boolean  modification = true;
				
		//@OneToMany(
				//   cascade = CascadeType.ALL, 
				//   orphanRemoval = true, 
				//   fetch = FetchType.EAGER)
				//	@JoinColumn(name = "channel_id")
				//	List<Message> messages = new ArrayList<>();
				
}