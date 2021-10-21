package com.misiontic.webfavorites.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.webfavorites.dtos.UserDTO;
import com.misiontic.webfavorites.entity.User;
import com.misiontic.webfavorites.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "*")
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

		return new ResponseEntity<>(userDto, HttpStatus.OK);

	}
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<UserDTO> findById(@PathVariable("userId") Long userId){
		User user = userService.fingById(userId);

		UserDTO userDto = UserDTO.builder()
				.id(user.getId())
				.name(user.getName())
				.password(user.getPassword())
				.email(user.getEmail())
				.build();

		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/user/{userId}")
	public ResponseEntity<Void> delete(@PathVariable("userId") Long userId){
		userService.delete(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/user")
	public ResponseEntity<UserDTO> create(@RequestBody User user){
		User newUserCreate = userService.save(user);

		UserDTO userDto = UserDTO.builder()
				.id(newUserCreate.getId())
				.name(newUserCreate.getName())
				.password(newUserCreate.getPassword())
				.email(newUserCreate.getEmail())
				.build();
		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping(value = "/user")
	public ResponseEntity<UserDTO> update(@RequestBody User user){
		User newUserUpdate = userService.save(user);

		UserDTO userDto = UserDTO.builder()
				.id(newUserUpdate.getId())
				.name(newUserUpdate.getName())
				.password(newUserUpdate.getPassword())
				.email(newUserUpdate.getEmail())
				.build();
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}


}
