package com.xcaliber.foodstall.service;

import java.util.List;

import com.xcaliber.foodstall.dto.AllFoodDto;
import com.xcaliber.foodstall.model.Drink;

public interface DrinkService {
	public void createDrink(AllFoodDto allFoodDto);
	public List<Drink> getAllDrink();
	public Drink findById(int id);
	public void update(Drink drink, int id);
	public void deleteDrinkById(int id);
	public String addDrinkInfo(AllFoodDto allFoodDto);
}
