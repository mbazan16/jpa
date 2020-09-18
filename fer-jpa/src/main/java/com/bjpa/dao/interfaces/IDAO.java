package com.bjpa.dao.interfaces;

import java.util.List;

import com.bjpa.exceptions.DAOException;

public interface IDAO<K,T> {
	
	public T find(K id) throws DAOException;
	
	public List<T> findAll() throws DAOException;
	
	public void create(T t) throws DAOException;
	
	public void save(T t) throws DAOException;
	
	public void delete(T t) throws DAOException;

}
