package com.bjpa.dao.interfaces;

import java.util.List;

public interface IDAO<T> {
	
	public T find(Long id);
	
	public List<T> findAll();
	
	public void create(T d);
	
	public void save(T d);
	
	public void delete(T d);

}
