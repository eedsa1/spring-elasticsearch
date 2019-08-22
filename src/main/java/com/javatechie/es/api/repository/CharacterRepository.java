package com.javatechie.es.api.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.javatechie.es.api.model.Character;

public interface CharacterRepository extends ElasticsearchRepository<Character, String>{
	List<Character> findByFirstname(String firstName);
}