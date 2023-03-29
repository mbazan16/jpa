package com.ejemplo.mysql;

import java.util.List;

import com.ejemplo.mysql.dao.DepartamentoDAO;
import com.ejemplo.mysql.dao.exceptions.DAOException;
import com.ejemplo.mysql.dao.interfaces.IDAO;
import com.ejemplo.mysql.dao.interfaces.IDAODepartamento;
import com.ejemplo.mysql.data.Departamento;

public class AppDepartamento {

	public static void main(String[] args) throws DAOException {
		IDAODepartamento dao = new DepartamentoDAO();
		System.out.println("----- Lista de departamentos -------------------");
		//List<Departamento> departamentos=dao.findAll();
		List<Departamento> departamentos=dao.findbyDireccionCiudad("Tokyo");
		for(Departamento departamento:departamentos) {
			System.out.println(departamento);
		}
		/*
		 * System.out.println("----- Departamento id=80 -------------------");
		 * Departamento departamento = dao.findById(80);
		 * System.out.println(departamento);
		 */
		
		/*
		 * System.out.println("----- Crear Departamento id=1000 -------------------");
		 * departamento = new Departamento(); departamento.setId(1000);
		 * departamento.setNombre("Alguno"); departamento.setManagerId(100);
		 * departamento.setLocationId(1700);
		 * 
		 * dao.create(departamento);
		 * 
		 * 
		 * departamento = dao.findById(1000); System.out.println(departamento);
		 * 
		 * System.out.println("----- Modificar Departamento id=1000 -------------------"
		 * ); departamento.setNombre("DepartamentoModificado");
		 * dao.update(departamento);
		 * 
		 * departamento = dao.findById(1000); System.out.println(departamento);
		 * 
		 * System.out.println("----- Eliminar Departamento id=1000 -------------------"
		 * ); dao.delete(1000);
		 * 
		 * departamento = dao.findById(1000); System.out.println(departamento);
		 */
		
	}

	
}
