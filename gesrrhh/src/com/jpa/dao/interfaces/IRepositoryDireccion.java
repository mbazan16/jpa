package com.jpa.dao.interfaces;

import java.util.List;

import com.jpa.entities.Direccion;
import com.jpa.exceptions.DAOException;

public interface IRepositoryDireccion extends DAO<Long,Direccion>{
	
	public List<Direccion> findAllByPais(String idPais) throws DAOException;
	
	public Direccion findOneByDepartamento(Long idDepartamento) throws DAOException;
	
	public List<Direccion> findAllPag(int pagina, int numElementosPag) throws DAOException;

}
