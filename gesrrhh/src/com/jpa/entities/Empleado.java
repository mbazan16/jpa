package com.jpa.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entidad Empleados que mapea la tabla EMPLOYEES
 * @author MARIA
 *
 */
@Entity
@Table(name = "EMPLOYEES")
@NamedQuery(name="findAll", query="SELECT e FROM Empleado e")
public class Empleado {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private long id;
	@Column(name = "FIRST_NAME")
	private String nombre;
	@Column (name = "LAST_NAME")
	private String apellidos;
	@Column (name = "EMAIL")
	private String email;
	@Column (name = "PHONE_NUMBER")
	private String telefono;
	@Column (name = "HIRE_DATE")
	private Date fechaContratacion;
	
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Trabajo trabajo;
	
	@Column (name = "SALARY")
	private int salario;
	@Column (name = "COMMISSION_PCT")
	private int comisionPCT;
	
	@Column (name = "MANAGER_ID")
	private Long idManager;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Departamento departamento;
	/**
	 * @return the nombreCompleto
	 */
	
	
	public Empleado() {
	}

	
	


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	

	public Trabajo getTrabajo() {
		return trabajo;
	}





	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}





	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getComisionPCT() {
		return comisionPCT;
	}

	public void setComisionPCT(int comisionPCT) {
		this.comisionPCT = comisionPCT;
	}


	

	public Long getIdManager() {
		return idManager;
	}





	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}





	public int getSalario() {
		return salario;
	}





	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}





	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", telefono=" + telefono + ", fechaContratacion=" + fechaContratacion + ", trabajo=" + trabajo
				+ ", salario=" + salario + ", comisionPCT=" + comisionPCT + ", idManager=" + idManager
				+ ", departamento=" + departamento + "]";
	}





	
	

	

	
}
	
