package com.bjpa.ln;

import java.util.List;

import com.bjpa.dao.DepartmentDAO;
import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Department;
import com.bjpa.ln.interfaces.IDepartment;

public class MngDepartment implements IDepartment {
	
	IDAO dao = new DepartmentDAO();

	public Department get(Long id) {
		return dao.find(id);
	}

	public List<Department> list() {
		return dao.findAll();
	}

	public void generate(Department d) {
		dao.create(d);
	}

	public void store(Department d) {
		dao.save(d);
	}

	public void destroy(Department d) {
		dao.delete(d);
	}

}
