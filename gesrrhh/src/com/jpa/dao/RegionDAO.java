package com.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.jpa.dao.interfaces.DAO;
import com.jpa.entities.Region;
import com.jpa.exceptions.DAOException;

public class RegionDAO implements DAO<Region,Long> {
	public static final Logger log = Logger.getLogger(com.jpa.dao.RegionDAO.class);
	
	
	//TODO -@PersistenceContext(name="HR")
	EntityManager em;
	
	//TODO -@PersistenceUnit(name="HR")
	EntityManagerFactory emf;

	@Override
	public Region find(Long id) throws DAOException {
		log.info("[find]");
		log.debug("Parameters:[id:"+id+"]");
		
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();
		
		
		
		Region element=null;
		try {
			element=em.find(Region.class, id);
			
		}catch(Exception e) {
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		return element;
	}

	@Override
	public List<Region> findAll() throws DAOException {
		log.info("[findAll]");
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();
		
		List<Region> elements=new ArrayList<Region>();
		try {
			elements=em.createNamedQuery("Region.findAll",Region.class).getResultList();
			//elements = em.createNativeQuery("SELECT * FROM REGIONS", Region.class).getResultList();
			//elements= em.createQuery("SELECT r FROM Region r", Region.class).getResultList();
			
		}catch(Exception e) {
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		return elements;
	}

	@Override
	public void crear(Region element) throws DAOException {
		log.info("[crear]");
		log.debug("Parameters:[region:"+element+"]");
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();
		
		
		
		try {
			em.getTransaction().begin();
			em.persist(element);
			em.getTransaction().commit();
			log.debug("Se ha creado la region");
		}catch(Exception e) {			
			em.getTransaction().rollback();
			log.debug("Rollback operacion");
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		
	}

	@Override
	public void modificar(Region element) throws DAOException {
		log.info("[modificar]");
		log.debug("Parameters:[region:"+element+"]");
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();		
		
		try {
			Region regionBBDD = em.find(Region.class, element.getId());
			
			em.getTransaction().begin();
			regionBBDD.setNombre(element.getNombre());
			em.getTransaction().commit();
			log.debug("Se ha creado la region");
		}catch(Exception e) {			
			em.getTransaction().rollback();
			log.debug("Rollback operacion");
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		
	}

	@Override
	public void eliminar(Long id) throws DAOException {
		log.info("[eliminar]");
		log.debug("Parameters:[id:"+id+"]");
		
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();		
		
		try {
			Region region = em.find(Region.class, id);			
			em.getTransaction().begin();
			em.remove(region);
			em.getTransaction().commit();
			log.debug("Se ha creado la region");
		}catch(Exception e) {			
			em.getTransaction().rollback();
			log.debug("Rollback operacion");
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
	}

}
