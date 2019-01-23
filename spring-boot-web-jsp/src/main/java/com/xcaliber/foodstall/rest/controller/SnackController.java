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

import com.xcaliber.foodstall.dto.AllFoodDto;
import com.xcaliber.foodstall.model.Snack;
import com.xcaliber.foodstall.service.SnackService;

@RestController
@RequestMapping("/snacks")
public class SnackController {
	@Autowired
	SnackService snackService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Snack> getById(@PathVariable("id") int id) {

		System.out.println("Fetching Snack with id " + id);

		Snack snack = snackService.findById(id);

		if (snack == null) {

			return new ResponseEntity<Snack>(HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<Snack>(snack, HttpStatus.OK);

	}

	@PostMapping(value = "/create", headers = "Accept=application/json")

	public ResponseEntity<Void> createSnack(@RequestBody AllFoodDto allFoodDto, UriComponentsBuilder ucBuilder) {

		snackService.createSnack(allFoodDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Snack> getAllSnack() {

		List<Snack> tasks = snackService.getAllSnack();

		return tasks;

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateSnack(@RequestBody Snack updateSnack) {

		System.out.println("id");
		Snack snack = snackService.findById(updateSnack.getSnacksId());

		if (snack == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		snackService.update(updateSnack, updateSnack.getSnacksId());

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Snack> deleteSnack(@PathVariable("id") int id) {
		
		Snack snack = snackService.findById(id);
		if (snack == null) {
			return new ResponseEntity<Snack>(HttpStatus.NOT_FOUND);
		}

		snackService.deleteSanckById(id);

		return new ResponseEntity<Snack>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/addSnack", headers = "Accept=application/json")
	public ResponseEntity<Void> addSnack(@RequestBody AllFoodDto allFoodDto, UriComponentsBuilder ucBuilder) {

		snackService.addSanckInfo(allFoodDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
