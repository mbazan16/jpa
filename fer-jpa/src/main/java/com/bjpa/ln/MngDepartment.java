package com.bjpa.ln;

import java.util.List;

import com.bjpa.dao.DepartmentDAO;
import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Department;
import com.bjpa.exceptions.DAOException;
import com.bjpa.ln.interfaces.IDepartment;

public class MngDepartment implements IDepartment {
	
	IDAO<Long, Department> dao = new DepartmentDAO();

	public Department get(Long id) {
		Department department =  null;
		try {
			department =  dao.find(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}

	public List<Department> list() {
		List<Department> list = null;
		try {
			list = dao.findAll();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void generate(Department d) {
		try {
			dao.create(d);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void store(Department d) {
		try {
			dao.save(d);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy(Department d) {
		try {
			dao.delete(d);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
