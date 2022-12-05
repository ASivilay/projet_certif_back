package fr.m2i.slackonslacertif.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="message")

public class Message implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(nullable = false, length = 20, name ="username")
		private String username;
		
		@Column(nullable = false, length = 255, name ="content")
		private String content;
		
		@Column(nullable = false, name ="datetime")
		private Date datetime;
	
		@ManyToOne(fetch=FetchType.LAZY)
		private Channel channel;

}

