package com.PhoneBookApplication.service;

import java.util.List;

public interface GenericService<T> {

	T save(T entity);
	
	List<T> findAll();

	T findById(Long id);

	void deleteById(Long id);

}