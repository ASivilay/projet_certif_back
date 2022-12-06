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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

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
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JsonIncludeProperties(value = {"id","username"})
		private User user;
		
		@Column(nullable = false, length = 255, name ="content")
		private String content;
		
		@Column(nullable = false, name ="date_time")
		private Date datetime;
	
		@ManyToOne(fetch=FetchType.EAGER)
		@JsonIncludeProperties(value = {"id","name"})
		private Channel channel;

		
}


