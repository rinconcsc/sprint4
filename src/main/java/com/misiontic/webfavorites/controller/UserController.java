package com.misiontic.webfavorites.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.webfavorites.dtos.UserDTO;
import com.misiontic.webfavorites.entity.User;
import com.misiontic.webfavorites.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/user")
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users= userService.findAll();
		
		List<UserDTO> userDto = users.stream().map(user -> {
			return UserDTO.builder()
					.id(user.getId())
					.name(user.getName())
					.password(user.getPassword())
					.email(user.getEmail())
					.build();
		}).collect(Collectors.toList());
		
		return new ResponseEntity<List<UserDTO>>(userDto, HttpStatus.OK);
		

		
	}
}
