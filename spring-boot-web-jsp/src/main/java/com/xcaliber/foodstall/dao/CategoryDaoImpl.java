package com.xcaliber.foodstall.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xcaliber.foodstall.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getAll() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Category> list = session.createCriteria(Category.class).list();
		return list;
	}

	@Override
	public Category findByName(String name) {
		
		Criteria  criteria = sessionFactory.openSession().createCriteria(Category.class)
				.add(Restrictions.eq("categoryName", name));
		return (Category) criteria.uniqueResult();
	}

}
