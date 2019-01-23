package com.xcaliber.foodstall.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xcaliber.foodstall.model.Item;
@Transactional
@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findByCategoryId(int categoryId) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Item.class)
				.add(Restrictions.eq("categoryId", categoryId));
		return criteria.list();
	}

	@Override
	public Item findById(Integer itemId) {
		return sessionFactory.getCurrentSession().get(Item.class, itemId);
	}

}
