package com.xcaliber.foodstall.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcaliber.foodstall.dao.PizzaDao;
import com.xcaliber.foodstall.dto.AllFoodDto;
import com.xcaliber.foodstall.model.Pizza;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {
	
	@Autowired
	PizzaDao pizzaDao;
	

	@Override
	public String addPizzaInfo(AllFoodDto allFoodDto) {
		Pizza pizza = new Pizza();
		pizza.setCheesePizza(allFoodDto.getCheesePizza());
		pizza.setVegPizza(allFoodDto.getVegPizza());
		
		pizzaDao.save(pizza);
		return null;
	}

	@Override
	public void createPizza(AllFoodDto allFoodDto) {
		//pizzaDao.save(allFodDto);
	}

	@Override
	public List<Pizza> getAllPizza() {
		return pizzaDao.findAll();
	}

	@Override
	public Pizza findById(int eId) {
		return pizzaDao.findOne(eId);
	}

	@Override
	public void update(Pizza pizza, int id) {
		pizzaDao.saveOrUpdate(pizza);
	}

	@Override
	public void deletePizzaById(int id) {
		pizzaDao.delete(findById(id));
	}
	
	


	

}
