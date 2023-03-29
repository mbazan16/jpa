package com.ejemplo.mysql.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
@NamedQuery(name ="Departamento.findAll",query = "SELECT d FROM Departamento d")
public class Departamento {
	@Id
	@Column(name="DEPARTMENT_ID")
	private Integer id;
	@Column(name="DEPARTMENT_NAME")
	private String nombre;
	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID")
	private Direccion direccion;
	
	
	
	public Departamento() {
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getManagerId() {
		return managerId;
	}



	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}



	public Direccion getDireccion() {
		return direccion;
	}



	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}



	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", managerId=" + managerId + ", direccion=" + direccion
				+ "]";
	}



	

	
	
	

}
