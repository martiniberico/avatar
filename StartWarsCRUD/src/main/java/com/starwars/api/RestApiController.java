package com.starwars.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.starwars.crud.dao.ConnectToRedis;
import com.starwars.crud.model.Person;
import com.starwars.service.ValidationService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@GetMapping("/person")
	public List<Person> listAllPersons() {
		//Retrieve all persons
		ConnectToRedis connectToRedis = new ConnectToRedis();
		connectToRedis.listCharacters();
		
		Person person = new Person();
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		return persons;
	}
	
	//OK
	@GetMapping("/person/{key}")
	public Person listPerson(@PathVariable("key") String key) {
		ConnectToRedis connectToRedis = new ConnectToRedis();
		return connectToRedis.listCharacter(key);
	}
	
	//OK
	@PostMapping("/person")
	public ResponseEntity<Object> createPerson(@RequestBody Person person) {
		
		ConnectToRedis connectToRedis = new ConnectToRedis();
		
		Person personPrevious = connectToRedis.listCharacter(person.getName().toLowerCase().replace(" ", "_"));
		if(personPrevious != null){
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("La persona ya está registrada");
		}
		
		ValidationService validationService = new ValidationService();
		if(!validationService.isValidPlanet(person.getPlanet())) {
			System.out.println("El nombre de planeta ingresado no existe");
			return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("El nombre de planeta ingresado no existe");
		}
		
		connectToRedis.saveCharacter(person);
		
		System.out.println("SAVE");
		System.out.println(person.toString());
		System.out.println(person.toJson());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(person.getName().toLowerCase().replace(" ", "_")).toUri();

		return ResponseEntity.created(location).build();
	}
	
	//OK
	@DeleteMapping("/person/{key}")
	public ResponseEntity<Object> deletePerson(@PathVariable("key") String key) {
		ConnectToRedis connectToRedis = new ConnectToRedis();
		Person person = connectToRedis.listCharacter(key);
		if(person != null) {
			connectToRedis.deleteCharacter(person);
			System.out.println("DELETE");
			System.out.println("Persona con key : " + key + " eliminada.");	
			return ResponseEntity
		            .status(HttpStatus.OK)
		            .body("Persona eliminada");
		}else {
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("La persona no existe");
		}
	}
	
	
	//OK
	@PutMapping("/person/{key}")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable String key) {

		//Find person to update
		ConnectToRedis connectToRedis = new ConnectToRedis();
		Person personToUpdate = connectToRedis.listCharacter(key);
		if(personToUpdate != null) {
			ValidationService validationService = new ValidationService();
			if(!validationService.isValidPlanet(person.getPlanet())) {
				System.out.println("El nombre de planeta ingresado no existe");
				return ResponseEntity
	            .status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("El nombre de planeta ingresado no existe");
			}
			
			connectToRedis.saveCharacter(person);
			System.out.println("UPDATE");
			System.out.println(person.toString());
			return ResponseEntity
		            .status(HttpStatus.OK)
		            .body("Persona actualizada");
		}else {
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("La persona no existe");
		}
	}

}
