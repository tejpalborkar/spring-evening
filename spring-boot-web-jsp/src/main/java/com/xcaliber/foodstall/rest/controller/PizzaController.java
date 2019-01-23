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
import com.xcaliber.foodstall.model.Pizza;
import com.xcaliber.foodstall.service.PizzaService;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Pizza> getPizzaById(@PathVariable("id") int id) {

		System.out.println("Fetching pizza with id " + id);

		Pizza pizza = pizzaService.findById(id);

		if (pizza == null) {

			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);

	}

	@PostMapping(value = "/create", headers = "Accept=application/json")

	public ResponseEntity<Void> createPizza(@RequestBody AllFoodDto allFoodDto, UriComponentsBuilder ucBuilder) {

		pizzaService.createPizza(allFoodDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Pizza> getAllPizza() {

		List<Pizza> tasks = pizzaService.getAllPizza();

		return tasks;

	}

	@PutMapping(value = "/update", headers = "Accept=application/json")
	public ResponseEntity<String> updatePizza(@RequestBody Pizza updatePizza) {

		System.out.println("sd");
		Pizza pizza = pizzaService.findById(updatePizza.getPizzaId());

		if (pizza == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

		pizzaService.update(updatePizza, updatePizza.getPizzaId());

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Pizza> deletePizza(@PathVariable("id") int id) {

		Pizza pizza = pizzaService.findById(id);
		if (pizza == null) {
			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
		}

		pizzaService.deletePizzaById(id);

		return new ResponseEntity<Pizza>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/addPizza", headers = "Accept=application/json")
	public ResponseEntity<Void> addUser(@RequestBody AllFoodDto allFoodDto, UriComponentsBuilder ucBuilder) {

		pizzaService.addPizzaInfo(allFoodDto);

		HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
