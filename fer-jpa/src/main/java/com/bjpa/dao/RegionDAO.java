package com.bjpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.bjpa.dao.interfaces.IDAO;
import com.bjpa.entities.Region;
import com.bjpa.exceptions.DAOException;

public class RegionDAO implements IDAO<Long, Region> {
	
	private final static Logger log = Logger.getLogger(RegionDAO.class);

	EntityManager em;

	public Region find(Long id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parameters:[Long id:" + id + "]");

		Region region = null;
		try {
			region = em.find(Region.class, id);
		} catch (Exception x) {
			throw new DAOException(x);
		}
		return region;
	}

	public List<Region> findAll() throws DAOException {
		log.info("Method:[findAll]");

		try {
			List<Region> list = new ArrayList<Region>();
			String query = "SELECT e FROM Employee e";
			TypedQuery<Region> tq = em.createQuery(query, Region.class);
			list = tq.getResultList();
			return list;
		} catch (Exception x) {
			throw new DAOException(x);
		}
	}

	public void create(Region r) throws DAOException {
		log.info("Method:[create]");
		log.debug("Parameters:[" + r.toString() + "]");

		em.getTransaction().begin();
		try {
			em.persist(r);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void save(Region r) throws DAOException {
		log.info("Method:[save]");
		log.debug("Parameters:[" + r.toString() + "]");

		Region region = find(r.getId());
		em.getTransaction().begin();
		try {
			region.setRegionNm(r.getRegionNm());
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

	public void delete(Region r) throws DAOException {
		log.info("Method:[delete]");
		log.debug("Parameters:[" + r.toString() + "]");

		em.getTransaction().begin();
		try {
			em.remove(r);
			em.getTransaction().commit();
		} catch (Exception x) {
			em.getTransaction().rollback();
			throw new DAOException(x);
		}
	}

}
