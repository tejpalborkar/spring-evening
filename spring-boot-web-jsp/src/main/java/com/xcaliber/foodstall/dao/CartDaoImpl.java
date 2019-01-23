package com.xcaliber.foodstall.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xcaliber.foodstall.model.Cart;

@Transactional
@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Cart findCartByCartId(Integer cartId) {
		return findOne(cartId);
	}

	@Override
	public void create(Cart Cart) {
		Session session = sessionFactory.openSession();
		session.save(Cart);
	}

	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Cart> list = session.createCriteria(Cart.class).list();
		return list;
	}

	public Cart update(Cart val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Cart Cart = (Cart) session.get(Cart.class, id);
		session.update(Cart);
		return Cart;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Cart Cart = findOne(id);
		session.delete(Cart);
	}

	@Override
	public Cart findCartByUserId(Integer userId) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eq("userId", userId)).add(Restrictions.eq("isCheckedout", false));
		return (Cart) criteria.uniqueResult();
	}

	@Override
	public void update(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cart);
//		session.beginTransaction().commit();
	}
	
	@Override
	public void merge(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(cart);
//		session.beginTransaction().commit();
	}

	@Override
	public Cart findOne(Integer cartId) {
		Session session = sessionFactory.openSession();
		Cart Cart = (Cart) session.get(Cart.class, cartId);
		return Cart;
	}

}
