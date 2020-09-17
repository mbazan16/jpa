package com.bjpa.dao.interfaces;

import java.util.List;

import com.bjpa.entities.Department;

public interface IDAO {
	
	public Department find(Long id);
	
	public List<Department> findAll();
	
	public void create(Department d);
	
	public void save(Department d);
	
	public void delete(Department d);

}
