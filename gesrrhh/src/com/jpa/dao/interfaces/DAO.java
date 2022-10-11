package com.jpa.dao.interfaces;

import java.util.List;

import com.jpa.exceptions.DAOException;

public interface DAO<T,K> {
	/**
	 * Método para encontrar un elemento por su id 
	 * @param id Identificador del elemento
	 * @return
	 * @throws DAOException
	 */
	public T find(K id) throws DAOException;
	
	/**
	 * Método para encontrar tododos los elementos de la base de datos
	 * @return Una Lista de objetos
	 * @throws DAOException
	 */
	public List<T> findAll() throws DAOException;
	
	/**
	 * Método para crear un elemento de la base de datos
	 * @param element
	 * @throws DAOException
	 */
	public void crear(T element) throws DAOException;
	
	/**
	 * Método para modificar un elemento de la base de datos
	 * @param element
	 * @throws DAOException
	 */
	public void modificar(T element) throws DAOException;
	
	/**
	 * Método para eliminar un elemento de la base de datos
	 * @param id Identificador del elemento
	 * @throws DAOException
	 */
	public void eliminar(K id) throws DAOException;

}
