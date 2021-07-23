package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuaderno database table.
 * 
 */
@Entity
@NamedQuery(name="Cuaderno.findAll", query="SELECT c FROM Cuaderno c")
public class Cuaderno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private long tipo;

	public Cuaderno() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTipo() {
		return this.tipo;
	}

	public void setTipo(long l) {
		this.tipo = l;
	}

}