package com.examples.model;

public class Departamento2 {

	private Long id;
	private String name;
	private Empleado jefeDepartamento;
	private Direccion direccion;
	
		
	public Departamento2() {
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

	public Empleado getJefeDepartamento() {
		if(jefeDepartamento==null)this.jefeDepartamento=new Empleado();
		return jefeDepartamento;
	}


	public void setJefeDepartamento(Empleado jefeDepartamento) {
		this.jefeDepartamento = jefeDepartamento;
	}


	public Direccion getDireccion() {
		if(direccion==null)this.direccion=new Direccion();
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Departamento2 [id=" + id + ", name=" + name + ", jefeDepartamento=" + jefeDepartamento + ", direccion="
				+ direccion + "]";
	}


	


	
}
