package com.xcaliber.foodstall.service;

import java.util.List;

import com.xcaliber.foodstall.dto.AllFoodDto;
import com.xcaliber.foodstall.model.Snack;

public interface SnackService {
	public void createSnack(AllFoodDto allFoodDto);
	public List<Snack> getAllSnack();
	public Snack findById(int id);
	public void update(Snack sanck, int id);
	public void deleteSanckById(int id);
	public String addSanckInfo(AllFoodDto allFoodDto);
}
