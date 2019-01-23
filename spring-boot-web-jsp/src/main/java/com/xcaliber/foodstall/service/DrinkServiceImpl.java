package com.xcaliber.foodstall.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcaliber.foodstall.dao.DrinkDao;
import com.xcaliber.foodstall.dto.AllFoodDto;
import com.xcaliber.foodstall.model.Drink;

@Service
@Transactional
public class DrinkServiceImpl implements DrinkService {
	@Autowired
	private DrinkDao drinkDao;

	@Override
	public String addDrinkInfo(AllFoodDto allFoodDto) {
		Drink drink = new Drink();
		drink.setCoke(allFoodDto.getCoke());
		drink.setSprite(allFoodDto.getSprite());

		drinkDao.save(drink);
		return null;
	}

	@Override
	public void createDrink(AllFoodDto allFoodDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Drink> getAllDrink() {
		// TODO Auto-generated method stub
		return drinkDao.findAll();
	}

	@Override
	public Drink findById(int id) {
		// TODO Auto-generated method stub
		return drinkDao.findOne(id);
	}

	@Override
	public void update(Drink drink, int id) {
		// TODO Auto-generated method stub
		drinkDao.saveOrUpdate(drink);
	}

	@Override
	public void deleteDrinkById(int id) {
		// TODO Auto-generated method stub
		drinkDao.delete(findById(id));
	}
}
