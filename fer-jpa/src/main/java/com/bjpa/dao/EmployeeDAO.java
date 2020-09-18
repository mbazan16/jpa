package com.bjpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Employee;
import com.bjpa.exceptions.DAOException;

public class EmployeeDAO implements IDAO<Long, Employee> {
	
	private final static Logger log = Logger.getLogger(EmployeeDAO.class);

	EntityManager em;

	public Employee find(Long id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parameters:[Long id:" + id + "]");

		Employee employee = null;
		try {
			employee = em.find(Employee.class, id);
		} catch (Exception x) {
			throw new DAOException(x);
		}
		return employee;
	}

	public List<Employee> findAll() throws DAOException {
		log.info("Method:[findAll]");

		try {
			List<Employee> list = new ArrayList<Employee>();
			String query = "SELECT e FROM Employee e";
			TypedQuery<Employee> tq = em.createQuery(query, Employee.class);
			list = tq.getResultList();
			return list;
		} catch (Exception x) {
			throw new DAOException(x);
		}
	}

	public void create(Employee e) throws DAOException {
		log.info("Method:[create]");
		log.debug("Parameters:[" + e.toString() + "]");

		em.getTransaction().begin();
		try {
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void save(Employee e) throws DAOException {
		log.info("Method:[save]");
		log.debug("Parameters:[" + e.toString() + "]");

		Employee employee = find(e.getId());
		em.getTransaction().begin();
		try {
			employee.setCommissionPct(e.getCommissionPct());
			employee.setEmail(e.getEmail());
			employee.setFirstNm(e.getFirstNm());
			employee.setHireDt(e.getHireDt());
			employee.setLastNm(e.getLastNm());
			employee.setPhoneNbr(e.getPhoneNbr());
			employee.setSalary(e.getSalary());
			employee.setDepartment(e.getDepartment());
			employee.setManager(e.getManager());
			e.setJob(e.getJob());
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void delete(Employee e) throws DAOException {
		log.info("Method:[delete]");
		log.debug("Parameters:[" + e.toString() + "]");

		em.getTransaction().begin();
		try {
			em.remove(e);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

}
