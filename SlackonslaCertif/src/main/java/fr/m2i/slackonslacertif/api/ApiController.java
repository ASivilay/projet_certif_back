package fr.m2i.slackonslacertif.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.m2i.slackonslacertif.models.Channel;
import fr.m2i.slackonslacertif.services.ChannelService;



@RestController
@RequestMapping(path="/api")
public class ApiController {
	
	
	@Autowired
	ChannelService cs;
	
	@GetMapping(
			path="/canalgeneral/listecanal",								//path / url
			produces={"application/json","application/xml"} //négociation de contenu / par défaut JSON
	)
	public List<Channel> getAll() { 
		

		return cs.getAll();
	}
	
	/*
	@PostMapping(
			path="/canalgeneral/ajoutcanal/form",										//path / url
			consumes={MediaType.MULTIPART_FORM_DATA_VALUE} 				//Par formulaire
	)
	@ResponseStatus(code=HttpStatus.CREATED)							//Optionnel permet de renvoyer un code HTTP de retour (200 OK, 204 No Content etc...)
	public void postFormItem(@ModelAttribute Item item) { 
		
		System.out.println(item);
	
		
	}
	
	@PostMapping(
			path="/canalgeneral/ajoutcanal/json",								//path / url
			consumes={MediaType.APPLICATION_JSON_VALUE} 			//par JSON
	)
	@ResponseStatus(code=HttpStatus.CREATED)						//Optionnel permet de renvoyer un code HTTP de retour (200 OK, 204 No Content etc...), ici 201
	public void postJsonItem(@RequestBody Item item) { 
		
		System.out.println(item);
	
		
	}

	
	/*
	 * PARTIE 3 CONSTRUCTION AVANCEE DE REPONSE
	 * 
	 * 
	 * 
	
		
	@PostMapping(
			path="/todolist/avance",								//path / url
			consumes={MediaType.APPLICATION_JSON_VALUE},			//par JSON
			produces={MediaType.APPLICATION_JSON_VALUE}
	)
	@ResponseStatus(code=HttpStatus.CREATED)						//Optionnel permet de renvoyer un code HTTP de retour (200 OK, 204 No Content etc...)
	public ResponseEntity<Item> reponseAvanceeList(@RequestBody Item item, UriComponentsBuilder uriBuilder) { 
		
		System.out.println(item);
		
		URI uri = uriBuilder.path("/api/todolist/{id}").buildAndExpand(item.getNom()).toUri(); //rajoute une location dans le header
        return ResponseEntity.created(uri).body(item);
	
		
	}
	@GetMapping(
			path="/todolist/{nom}")
	@ResponseStatus					//Optionnel permet de renvoyer un code HTTP de retour (200 OK, 204 No Content etc...)
	public Item reponseNomItem(@PathVariable String nom) { 
		
		System.out.println(nom);
	
		return new Item();
	}
	 */
}