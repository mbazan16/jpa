package com.bjpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Job;
import com.bjpa.exceptions.DAOException;

public class JobDAO implements IDAO<String, Job> {
	
	private final static Logger log = Logger.getLogger(JobDAO.class);

	EntityManager em;

	public Job find(String id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parameters:[Long id:" + id + "]");

		Job job = null;
		try {
			job = em.find(Job.class, id);
		} catch (Exception x) {
			throw new DAOException(x);
		}
		return job;
	}

	public List<Job> findAll() throws DAOException {
		log.info("Method:[findAll]");

		try {
			List<Job> list = new ArrayList<Job>();
			String query = "SELECT e FROM Employee e";
			TypedQuery<Job> tq = em.createQuery(query, Job.class);
			list = tq.getResultList();
			return list;
		} catch (Exception x) {
			throw new DAOException(x);
		}
	}

	public void create(Job j) throws DAOException {
		log.info("Method:[create]");
		log.debug("Parameters:[" + j.toString() + "]");

		em.getTransaction().begin();
		try {
			em.persist(j);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void save(Job j) throws DAOException {
		log.info("Method:[save]");
		log.debug("Parameters:[" + j.toString() + "]");

		Job job = find(j.getId());
		em.getTransaction().begin();
		try {
			job.setJobTtl(j.getJobTtl());
			job.setMaxSalary(j.getMaxSalary());
			job.setMinSalary(j.getMinSalary());
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void delete(Job j) throws DAOException {
		log.info("Method:[delete]");
		log.debug("Parameters:[" + j.toString() + "]");

		em.getTransaction().begin();
		try {
			em.remove(j);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

}
