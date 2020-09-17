package com.bjpa.ln.interfaces;

import java.util.List;

import com.bjpa.entities.Department;

public interface IDepartment {
	
	public Department get(Long id);
	
	public List<Department> list();
	
	public void generate(Department d);
	
	public void store(Department d);
	
	public void destroy(Department d);

}
