package com.examples.model;

public class Departamento {

	private Long id;
	private String name;
	private Long managerId;
	private Long locationId;
	
		
	public Departamento() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}


	@Override
	public String toString() {
		return "Departamento [id=" + id + ", name=" + name + ", managerId=" + managerId + ", locationId=" + locationId
				+ "]";
	}
}
