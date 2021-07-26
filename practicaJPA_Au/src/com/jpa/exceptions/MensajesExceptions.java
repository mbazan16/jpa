package com.jpa.exceptions;

public enum MensajesExceptions {
	NO_EXISTE_CUADERNO("No existe cuaderno"),
	EXISTE_CUADERNO("Existe cuaderno"),
	NO_EXISTE_TIPO("No existe tipo"),
	EXISTE_TIPO("Existe tipo"),
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
