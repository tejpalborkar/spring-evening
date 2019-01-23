package com.xcaliber.foodstall.dao;

import org.springframework.stereotype.Repository;

import com.xcaliber.foodstall.model.User;
import com.xcaliber.foodstall.repository.GenericDaoImpl;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Long>  implements UserDao{


}
