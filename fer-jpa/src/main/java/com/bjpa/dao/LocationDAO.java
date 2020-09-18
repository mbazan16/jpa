package com.bjpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Location;
import com.bjpa.exceptions.DAOException;

public class LocationDAO implements IDAO<Long, Location> {
	
	private final static Logger log = Logger.getLogger(LocationDAO.class);

	EntityManager em;

	public Location find(Long id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parameters:[Long id:" + id + "]");

		Location location = null;
		try {
			location = em.find(Location.class, id);
		} catch (Exception x) {
			throw new DAOException(x);
		}
		return location;
	}

	public List<Location> findAll() throws DAOException {
		log.info("Method:[findAll]");

		try {
			List<Location> list = new ArrayList<Location>();
			String query = "SELECT e FROM Employee e";
			TypedQuery<Location> tq = em.createQuery(query, Location.class);
			list = tq.getResultList();
			return list;
		} catch (Exception x) {
			throw new DAOException(x);
		}
	}

	public void create(Location l) throws DAOException {
		log.info("Method:[create]");
		log.debug("Parameters:[" + l.toString() + "]");

		em.getTransaction().begin();
		try {
			em.persist(l);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void save(Location l) throws DAOException {
		log.info("Method:[save]");
		log.debug("Parameters:[" + l.toString() + "]");

		Location location = find(l.getId());
		em.getTransaction().begin();
		try {
			location.setAdministration(l.getAdministration());
			location.setCity(l.getCity());
			location.setCountry(l.getCountry());
			location.setPostalCd(l.getPostalCd());
			location.setStreetAddr(l.getStreetAddr());
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void delete(Location l) throws DAOException {
		log.info("Method:[delete]");
		log.debug("Parameters:[" + l.toString() + "]");

		em.getTransaction().begin();
		try {
			em.remove(l);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

}
