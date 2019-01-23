package com.xcaliber.foodstall.service;

import java.util.List;

import com.xcaliber.foodstall.dto.AllFoodDto;
import com.xcaliber.foodstall.model.Pizza;

public interface PizzaService {
	public void createPizza(AllFoodDto allFoodDto);
	public List<Pizza> getAllPizza();
	public Pizza findById(int id);
	public void update(Pizza user, int id);
	public void deletePizzaById(int id);
	public String addPizzaInfo(AllFoodDto allFoodDto);
}
