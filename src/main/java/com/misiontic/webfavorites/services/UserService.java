package com.misiontic.webfavorites.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.webfavorites.entity.User;
import com.misiontic.webfavorites.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> findAll() {
		List<User> users= userRepo.findAll();
		return users;
	}
}
