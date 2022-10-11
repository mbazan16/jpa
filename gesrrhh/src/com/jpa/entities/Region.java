package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the REGIONS database table.
 * 
 */
@Entity
@Table(name="REGIONS")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REGION_ID")
	private Long id;

	@Column(name="REGION_NAME")
	private String nombre;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="region")
	private List<Pais> paises;

	public Region() {
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

	

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public Pais addPais(Pais pais) {
		getPaises().add(pais);
		pais.setRegion(this);

		return pais;
	}

	public Pais removeCountry(Pais pais) {
		getPaises().remove(pais);
		pais.setRegion(null);

		return pais;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

}