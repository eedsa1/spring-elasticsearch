package com.javatechie.es.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.es.api.model.Character;
import com.javatechie.es.api.repository.CharacterRepository;

@SpringBootApplication
@RestController
public class CharacterController {
	
	@Autowired
	private CharacterRepository repository;
	
	@PostMapping("/saveCharacter")
	public int saveCustomer(@RequestBody List<Character> characters) {
		repository.saveAll(characters);
		return characters.size();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Character> findById(@PathVariable String id) {
		return repository.findById(id);
	}

	@GetMapping("/findAll")
	public Iterable<Character> findAllCharacters() {
		return repository.findAll();
	}
	
	@DeleteMapping("/removeById/{id}")
	public void removeById(@PathVariable String id) {
		repository.deleteById(id);
	}
	
	@DeleteMapping("/removeAll")
	public void removeAll() {
		repository.deleteAll();
	}

	@GetMapping("/findByFName/{firstName}")
	public List<Character> findByFirstName(@PathVariable String firstName) {
		return repository.findByFirstname(firstName);
	}
}
