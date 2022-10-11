package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COUNTRIES database table.
 * 
 */
@Entity
@Table(name="COUNTRIES")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COUNTRY_ID")
	private String id;

	@Column(name="COUNTRY_NAME")
	private String nombre;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="REGION_ID")
	private Region region;

	public Pais() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", region=" + region + "]";
	}
	
	

}