package com.bjpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.bjpa.exceptions.DAOException;
import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Department;
import com.bjpa.dao.DepartmentDAO;

public class DepartmentDAO implements IDAO<Long, Department> {

	private final static Logger log = Logger.getLogger(DepartmentDAO.class);

	EntityManager em;

	public Department find(Long id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parameters:[Long id:" + id + "]");

		try {
			Department department = em.find(Department.class, id);
			return department;
		} catch (Exception x) {
			throw new DAOException(x);
		}
	}

	public List<Department> findAll() throws DAOException {
		log.info("Method:[findAll]");

		try {
			List<Department> list = new ArrayList<Department>();
			String query = "SELECT d FROM Department d";
			TypedQuery<Department> tq = em.createQuery(query, Department.class);
			list = tq.getResultList();
			return list;
		} catch (Exception x) {
			throw new DAOException(x);
		}
	}

	public Department findByEmployee(Long id) {
		log.info("Method:[findByEmployee]");
		log.debug("Parameters:[Long id:" + id + "]");

		Department department = null;
		String query = "SELECT e.department FROM Employee e WHERE e.id = :employeeId";
		TypedQuery<Department> tq = em.createQuery(query, Department.class);
		department = tq.setParameter("employeeId", id).getSingleResult();
		return department;
	}

	public List<Department> findByLocation(Long id) {
		log.info("Method:[findByLocation]");
		log.debug("Parameters:[Long id:" + id + "]");

		List<Department> list = new ArrayList<Department>();
		String query = "SELECT d FROM Department d WHERE d.location.id = :locationId";
		TypedQuery<Department> tq = em.createQuery(query, Department.class);
		list = tq.setParameter("locationId", id).getResultList();
		return list;
	}

	public List<Department> findByCountry(Long id) {
		log.info("Method:[findByCountry]");
		log.debug("Parameters:[Long id:" + id + "]");

		List<Department> list = new ArrayList<Department>();
		String query = "SELECT d FROM Department d WHERE d.location.country.id = :countryId";
		TypedQuery<Department> tq = em.createQuery(query, Department.class);
		list = tq.setParameter("countryId", id).getResultList();
		return list;
	}

	public void create(Department d) throws DAOException {
		log.info("Method:[create]");
		log.debug("Parameters:[" + d.toString() + "]");

		em.getTransaction().begin();
		try {
			em.persist(d);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void save(Department d) throws DAOException {
		log.info("Method:[save]");
		log.debug("Parameters:[" + d.toString() + "]");

		Department department = find(d.getId());
		em.getTransaction().begin();
		try {
			department.setName(d.getName());
			department.setManager(d.getManager());
			department.setLocation(d.getLocation());
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void delete(Department d) throws DAOException {
		log.info("Method:[delete]");
		log.debug("Parameters:[" + d.toString() + "]");

		em.getTransaction().begin();
		try {
			em.remove(d);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

}
