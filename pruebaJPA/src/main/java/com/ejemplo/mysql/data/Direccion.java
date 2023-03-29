package com.ejemplo.mysql.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
@NamedQuery(name ="Direccion.findAll",query = "SELECT d FROM Direccion d")
public class Direccion {
	@Id
	@Column(name="LOCATION_ID")
	private Integer id;
	@Column(name="STREET_ADDRESS")
	private String calle;
	@Column(name="POSTAL_CODE")
	private String codigoPostal;
	@Column(name="CITY")
	private String ciudad;
	@Column(name="STATE_PROVINCE")
	private String provincia;
	@Column(name="COUNTRY_ID")
	private String paisId;
	
	
	public Direccion() {
		
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getPaisId() {
		return paisId;
	}



	public void setPaisId(String paisId) {
		this.paisId = paisId;
	}



	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad
				+ ", provincia=" + provincia + ", paisId=" + paisId + "]";
	}



	
	
	
	

}
