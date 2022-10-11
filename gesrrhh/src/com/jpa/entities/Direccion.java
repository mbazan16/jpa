package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entidad Direccion que mapea la tabla LOCATIONS
 * @author MARIA
 *
 */
@Entity
@Table(name="LOCATIONS")
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	private long id;

	@Column(name="CITY")
	private String ciudad;

	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Pais pais;

	@Column(name="POSTAL_CODE")
	private String codigoPostal;

	@Column(name="STATE_PROVINCE")
	private String provincia;

	@Column(name="STREET_ADDRESS")
	private String calle;

	public Direccion() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Pais getPais() {
		if(this.pais==null) this.pais= new Pais();
		return pais;
	}

	public void setPais(Pais pais) {		
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", pais=" + pais + ", codigoPostal=" + codigoPostal
				+ ", provincia=" + provincia + ", calle=" + calle + "]";
	}

	

	
}