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
@NamedQueries({
 @NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d"),
 @NamedQuery(name="Direccion.findAllByPais", query="SELECT d FROM Direccion d WHERE d.idPais= :id"),
 @NamedQuery(name="Direccion.findOneByDepartamento", 
 				query="SELECT d FROM Departamento de, Direccion d WHERE d.id=de.idDireccion AND de.id = :id")
 //Si estuviera el objeto Direccion dentro de Departamento
//@NamedQuery(name="Direccion.finOneByDepartamento", query="select  d.direccion from Departamento d where d.id= :id")
})
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	private long id;

	@Column(name="CITY")
	private String ciudad;

	@Column(name="COUNTRY_ID")
	private String idPais;

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

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
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
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", idPais=" + idPais + ", codigoPostal=" + codigoPostal
				+ ", provincia=" + provincia + ", calle=" + calle + "]";
	}

	
}