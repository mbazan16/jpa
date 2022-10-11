package com.jpa.dao.interfaces;

import java.util.List;

import com.jpa.entities.Departamento;
import com.jpa.exceptions.DAOException;

public interface IDepartamentoDAO extends DAO<Departamento> {
	
	public List<Departamento> buscarPorJefeDepartmento(Long idJefeDepartamento) throws DAOException;
	public Departamento buscarPorEmpleado(Long idEmpleado) throws DAOException;
	public Long darNumeroEmpleadosDepartamento(Long idDepartamento) throws DAOException;
	public List<Departamento> buscarPorDireccion(Long idDireccion) throws DAOException;

}
