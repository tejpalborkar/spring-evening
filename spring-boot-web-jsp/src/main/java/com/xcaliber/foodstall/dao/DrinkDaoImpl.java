package com.xcaliber.foodstall.dao;

import org.springframework.stereotype.Repository;

import com.xcaliber.foodstall.model.Drink;
import com.xcaliber.foodstall.repository.GenericDaoImpl;

@Repository
public class DrinkDaoImpl extends GenericDaoImpl<Drink,Long>  implements DrinkDao{

}
