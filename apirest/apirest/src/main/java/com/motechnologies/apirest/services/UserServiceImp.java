package com.motechnologies.apirest.services;

import com.motechnologies.apirest.models.User;
import com.motechnologies.apirest.repositorys.TestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    
    @Autowired
    TestRepository testRepository;

    @Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return this.testRepository.save(user);
	}
}
