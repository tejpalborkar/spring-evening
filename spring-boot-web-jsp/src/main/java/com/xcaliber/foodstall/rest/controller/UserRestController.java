package com.xcaliber.foodstall.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.xcaliber.foodstall.dto.UserRegistrationDto;
import com.xcaliber.foodstall.model.User;
import com.xcaliber.foodstall.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {

		System.out.println("Fetching User with id " + id);

		User user = userService.findById(id);

		if (user == null) {

			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@PostMapping(value = "/create", headers = "Accept=application/json")

	public ResponseEntity<Void> createUser(@RequestBody UserRegistrationDto userDto, UriComponentsBuilder ucBuilder) {

		userService.createUser(userDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<User> getAllUser() {

		List<User> tasks = userService.getAllUser();

		return tasks;

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateUser(@RequestBody User currentUser) {

		System.out.println("sd");
		User user = userService.findById(currentUser.getUserId());

		if (user == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		userService.update(currentUser, currentUser.getUserId());

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {

		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(id);

		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/addUser", headers = "Accept=application/json")
	public ResponseEntity<Void> addUser(@RequestBody UserRegistrationDto userDto, UriComponentsBuilder ucBuilder) {

		userService.addUserInfo(userDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}