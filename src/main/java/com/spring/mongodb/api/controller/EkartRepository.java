package com.spring.mongodb.api.controller;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.mongodb.api.model.User;

public interface EkartRepository extends MongoRepository<User, Integer>{

	List<User> findByName(String name);

	@Query("{'Address.city':?0}")
	List<User> findByCity(String city);

}
