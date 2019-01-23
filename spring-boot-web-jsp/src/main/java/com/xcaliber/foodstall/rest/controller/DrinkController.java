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
import com.xcaliber.foodstall.model.Drink;
import com.xcaliber.foodstall.service.DrinkService;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
	
	@Autowired
	DrinkService drinkService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Drink> getDrinkById(@PathVariable("id") int id) {

		System.out.println("Fetching drink with id " + id);

		Drink drink = drinkService.findById(id);

		if (drink == null) {

			return new ResponseEntity<Drink>(HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<Drink>(drink, HttpStatus.OK);

	}

	@PostMapping(value = "/create", headers = "Accept=application/json")

	public ResponseEntity<Void> createDrink(@RequestBody AllFoodDto allFoodDto, UriComponentsBuilder ucBuilder) {

		drinkService.createDrink(allFoodDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Drink> getAllDrink() {

		List<Drink> tasks = drinkService.getAllDrink();
		return tasks;

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updateDrink(@RequestBody Drink updateDrink) {

		System.out.println("id");
		Drink drink = drinkService.findById(updateDrink.getSnacksId());

		if (drink == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		drinkService.update(updateDrink, updateDrink.getSnacksId());

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Drink> deleteDrink(@PathVariable("id") int id) {
		
		Drink drink = drinkService.findById(id);
		if (drink == null) {
			return new ResponseEntity<Drink>(HttpStatus.NOT_FOUND);
		}

		drinkService.deleteDrinkById(id);

		return new ResponseEntity<Drink>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/addDrink", headers = "Accept=application/json")
	public ResponseEntity<Void> addDrink(@RequestBody AllFoodDto allFoodDto, UriComponentsBuilder ucBuilder) {

		drinkService.addDrinkInfo(allFoodDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
