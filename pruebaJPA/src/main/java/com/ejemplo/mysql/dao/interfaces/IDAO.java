package com.ejemplo.mysql.dao.interfaces;

import java.util.List;

import com.ejemplo.mysql.dao.exceptions.DAOException;

public interface IDAO<T,K> {
	
	List<T> findAll() throws DAOException;

	T findById(K id) throws DAOException;

	void create(T element) throws DAOException;

	void update(T element) throws DAOException;

	void delete(K id) throws DAOException;

}
