package com.bjpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Department;

public class DepartmentDAO implements IDAO {

	EntityManager em;

	public Department find(Long id) {
		Department department = em.find(Department.class, id);
		return department;
	}

	public List<Department> findAll() {
		List<Department> list = new ArrayList<Department>();
		list = em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
		return list;
	}

	public void create(Department d) {
		Department department = find(d.getId());
		if (department != null) {
			System.out.println("Department " + d.getId() + " already exists. Updating.");
			save(d);
		} else {
			em.getTransaction().begin();
			em.persist(d);
			em.getTransaction().commit();
		}
	}

	public void save(Department d) {
		Department department = find(d.getId());
		if (department != null) {
			em.getTransaction().begin();
			department.setName(d.getName());
			department.setManagerId(d.getManagerId());
			department.setLocationId(d.getLocationId());
			em.getTransaction().commit();
		} else {
			System.out.println("Department " + d.getId() + " does not exist. Creating.");
			create(d);
		}
	}

	public void delete(Department d) {
		em.getTransaction().begin();
		em.remove(d);
		em.getTransaction().commit();
	}

}
