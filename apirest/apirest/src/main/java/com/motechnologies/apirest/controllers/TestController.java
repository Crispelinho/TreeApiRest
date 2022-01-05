package com.motechnologies.apirest.controllers;

import com.motechnologies.apirest.models.User;
import com.motechnologies.apirest.repositorys.TestRepository;
import com.motechnologies.apirest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

    @Autowired
    UserService userService;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        System.out.println(user.getName());
        return userService.save(user);

    }
}