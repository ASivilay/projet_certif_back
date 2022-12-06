package fr.m2i.slackonslacertif.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="channel")
public class Channel implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(nullable = false, length = 20, name ="name")
		private String name;
			
		@Column(nullable = false, name ="modification")
		private boolean  modification = true;
				
		@OneToMany(mappedBy = "channel", cascade=CascadeType.ALL)
		@JsonIncludeProperties(value = {"username","content"})
		public List<Message> messages = new ArrayList<>();
		
		
		
		public void addMessage (Message message) {
			messages.add(message);
		}
			
		public void removeMessage (Message message) {
			messages.remove(message);
		}
		
}
