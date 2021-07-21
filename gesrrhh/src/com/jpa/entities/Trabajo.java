package com.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Entidad Trabajo que mapea la tabla JOBS
 * @author MARIA
 *
 */
@Entity
@Table(name="JOBS")
@NamedQuery(name="Trabajo.findAll", query="SELECT t FROM Trabajo t")
public class Trabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JOB_ID")
	private String id;

	@Column(name="JOB_TITLE")
	private String titulos;

	@Column(name="MAX_SALARY")
	private BigDecimal maximoSalario;

	@Column(name="MIN_SALARY")
	private BigDecimal minimoSalario;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="JOB_ID")
	List<Empleado> empleados;

	public Trabajo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulos() {
		return titulos;
	}

	public void setTitulos(String titulos) {
		this.titulos = titulos;
	}

	public BigDecimal getMaximoSalario() {
		return maximoSalario;
	}

	public void setMaximoSalario(BigDecimal maximoSalario) {
		this.maximoSalario = maximoSalario;
	}

	public BigDecimal getMinimoSalario() {
		return minimoSalario;
	}

	public void setMinimoSalario(BigDecimal minimoSalario) {
		this.minimoSalario = minimoSalario;
	}	
	

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	/*
	 * @Override public String toString() { return "Trabajo [id=" + id +
	 * ", titulos=" + titulos + ", maximoSalario=" + maximoSalario +
	 * ", minimoSalario=" + minimoSalario + "]"; }
	 */

	

}