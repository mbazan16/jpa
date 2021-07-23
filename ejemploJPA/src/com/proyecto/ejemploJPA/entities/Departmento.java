package com.proyecto.ejemploJPA.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name="departments")
@NamedQuery(name="Departmento.findAll", query="SELECT d FROM Departmento d")
public class Departmento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="department_id")
	private Long id;

	@Column(name="department_name")
	private String nombre;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Employee employee;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="department")
	private List<Employee> employees;

	public Departmento() {
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}

}