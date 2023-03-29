package com.ejemplo.mysql.dao.exceptions;

public class DAOException extends Exception {

	 int  codigo;

	public DAOException(int codigo) {
		super();
		this.codigo = codigo;
	}
	   
	 
	
}
