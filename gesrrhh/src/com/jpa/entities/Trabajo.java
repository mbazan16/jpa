package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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

	@Override
	public String toString() {
		return "Trabajo [id=" + id + ", titulos=" + titulos + ", maximoSalario=" + maximoSalario + ", minimoSalario="
				+ minimoSalario + "]";
	}

	

}