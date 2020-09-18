package com.bjpa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {

	@Id
	@Column(name = "DEPARTMENT_ID")
	private Long id;
	@Column(name = "DEPARTMENT_NAME")
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Employee> staff;

	@ManyToOne
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee deptManager;

	public Department() {
		super();
	}

	public Department(Long id, String name, Employee manager, Location location) {
		super();
		this.id = id;
		this.name = name;
		this.deptManager = manager;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getStaff() {
		return staff;
	}

	public void setStaff(List<Employee> staff) {
		this.staff = staff;
	}

	public Employee addStaff(Employee employee) {
		getStaff().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Employee removeStaff(Employee employee) {
		getStaff().remove(employee);
		employee.setDepartment(null);

		return employee;
	}

	public Employee getManager() {
		return deptManager;
	}

	public void setManager(Employee manager) {
		this.deptManager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager=" + deptManager.getFirstNm()
				+ " " + deptManager.getLastNm() + ", location=" + location.getCity() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
