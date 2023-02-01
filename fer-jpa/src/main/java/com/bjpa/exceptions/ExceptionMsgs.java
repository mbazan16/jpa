package com.bjpa.exceptions;

public enum ExceptionMsgs {
	DEPT_NONEXISTENT("The department does not exist"),
	DEPT_EXISTENT("The department already exists"),
	EMPL_NONEXISTENT("The employee does not exist"),
	EMPL_EXISTENT("The employee already exists"),
	LOCN_NONEXISTENT("The location does not exist"),
	LOCN_EXISTENT("The location already exists"),
	RG_EXISTENT("The region already exists"),
	RG_NONEXISTENT("The region does not exists"),
	;
	
	
	private String description;
	
	private ExceptionMsgs(String descripcion) {
		this.description=descripcion;
	}
	
	public String getDescripcion() {
		return this.description;
	}

}
