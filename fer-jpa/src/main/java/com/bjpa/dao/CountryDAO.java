package com.bjpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Country;
import com.bjpa.exceptions.DAOException;

public class CountryDAO implements IDAO<String, Country> {
	
	private final static Logger log = Logger.getLogger(CountryDAO.class);

	EntityManager em;

	public Country find(String id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parameters:[String id:" + id + "]");

		Country country = null;
		try {
			country = em.find(Country.class, id);
		} catch (Exception x) {
			throw new DAOException(x);
		}
		return country;
	}

	public List<Country> findAll() throws DAOException {
		log.info("Method:[findAll]");

		try {
			List<Country> list = new ArrayList<Country>();
			String query = "SELECT c FROM Country c";
			TypedQuery<Country> tq = em.createQuery(query, Country.class);
			list = tq.getResultList();
			return list;
		} catch (Exception x) {
			throw new DAOException(x);
		}
	}

	public void create(Country c) throws DAOException {
		log.info("Method:[create]");
		log.debug("Parameters:[" + c.toString() + "]");

		em.getTransaction().begin();
		try {
			em.persist(c);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void save(Country c) throws DAOException {
		log.info("Method:[save]");
		log.debug("Parameters:[" + c.toString() + "]");

		Country country = find(c.getId());
		em.getTransaction().begin();
		try {
			country.setCountryNm(c.getCountryNm());
			country.setRegion(c.getRegion());
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void delete(Country c) throws DAOException {
		log.info("Method:[delete]");
		log.debug("Parameters:[" + c.toString() + "]");

		em.getTransaction().begin();
		try {
			em.remove(c);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

}
