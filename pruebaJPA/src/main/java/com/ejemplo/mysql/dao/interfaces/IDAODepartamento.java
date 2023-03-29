package com.ejemplo.mysql.dao.interfaces;

import java.util.List;

import com.ejemplo.mysql.dao.exceptions.DAOException;
import com.ejemplo.mysql.data.Departamento;

public interface IDAODepartamento extends IDAO<Departamento,Integer>{
	
	public List<Departamento> findbyDireccionId(Integer direccionId)throws DAOException;
	
	public List<Departamento> findbyDireccionCiudad(String ciudad)throws DAOException;

}
