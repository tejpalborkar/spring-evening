package com.xcaliber.foodstall.dao;

import org.springframework.stereotype.Repository;

import com.xcaliber.foodstall.model.Snack;
import com.xcaliber.foodstall.repository.GenericDaoImpl;

@Repository
public class SnackDaoImpl extends GenericDaoImpl<Snack,Long>  implements SnackDao{

}
