package com.jpa.exceptions;

public enum MensajesExceptions {
	NO_EXISTE_DEPARTAMENTO("No existe departamento"),
	EXISTE_DEPARTAMENTO("Existe depatarmento"),
	NO_EXISTE_EMPLEADO("No existe empleado"),
	EXISTE_EMPLEADO("Existe empleado"),
	NO_EXISTE_DIRECCION("No existe dirección"),
	EXISTE_DIRECCION("Existe dirección");
	
	private String descripcion;
	
	private MensajesExceptions(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

}
