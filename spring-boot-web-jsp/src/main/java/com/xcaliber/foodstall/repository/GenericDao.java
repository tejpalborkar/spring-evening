package com.xcaliber.foodstall.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <E, K extends Serializable> {
	public void save(E entity);
	
	public void saveOrUpdate(E entity);
	
	public E findOne(long eId);
	
	public List<E> findAll();
	
	public void delete(E entiry);

}
