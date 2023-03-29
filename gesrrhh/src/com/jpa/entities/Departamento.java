package com.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad Departamento que mapea la tabla DEPARTMENTS
 * @author MARIA
 *
 */
@Entity
@Table(name = "DEPARTMENTS")
@NamedQueries({ 
	@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d"),
	@NamedQuery(name="Departamento.findByJefeDepartamento", query="SELECT d FROM Departamento d WHERE d.idManager=?1"),
	@NamedQuery(name="Departamento.findbyEmpleado", query="SELECT e.departamento FROM Empleado e WHERE e.id=:pepe"),
	@NamedQuery(name="Departamento.countEmpleados", query="SELECT count(e) FROM Empleado e WHERE e.departamento.id=:id")
})
public class Departamento {
	
	@Id
	@Column(name = "DEPARTMENT_ID")
	private Long id;
	@Column(name = "DEPARTMENT_NAME")
	private String nombre;
	

	@Column(name="MANAGER_ID")
	private Long idManager;
	
	@ManyToOne
	@JoinColumn(name="LOCATION_ID")
	private Direccion direccion;
	
	@OneToMany(mappedBy = "departamento",fetch=FetchType.LAZY)
	private List<Empleado> empleados;
	
	public Departamento() {
		super();
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdManager() {
		return idManager;
	}



	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}



	public Direccion getDireccion() {
		if(this.direccion==null) this.direccion= new Direccion();
		return direccion;
	}



	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}



	public List<Empleado> getEmpleados() {
		if(empleados==null) empleados=new ArrayList<Empleado>();
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	

	

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", idManager=" + idManager
				+ ", direccion=" + direccion + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if(this.getDireccion().getId()!=other.getDireccion().getId())
			return false;
		if(this.idManager!=other.idManager)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
