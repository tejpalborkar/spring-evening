package com.xcaliber.foodstall.dao;

import org.springframework.stereotype.Repository;

import com.xcaliber.foodstall.model.Pizza;
import com.xcaliber.foodstall.repository.GenericDaoImpl;
import com.xcaliber.foodstall.dao.PizzaDao;

@Repository
public class PizzaDaoImpl extends GenericDaoImpl<Pizza,Long>  implements PizzaDao  {
	
}
