package com.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.jpa.dao.interfaces.DAO;
import com.jpa.entities.Pais;
import com.jpa.entities.Region;
import com.jpa.exceptions.DAOException;

public class PaisDAO implements DAO<Pais,String> {
	public static final Logger log = Logger.getLogger(com.jpa.dao.PaisDAO.class);
	
	
	//TODO -@PersistenceContext(name="HR")
	EntityManager em;
	
	//TODO -@PersistenceUnit(name="HR")
	EntityManagerFactory emf;

	@Override
	public Pais find(String id) throws DAOException {
		log.info("[find]");
		log.debug("Parameters:[id:"+id+"]");
		
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();
		
		Pais element=null;
		try {
			element=em.find(Pais.class, id);
			
		}catch(Exception e) {
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		return element;
	}

	@Override
	public List<Pais> findAll() throws DAOException {
		log.info("[findAll]");
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();
		
		List<Pais> elements=new ArrayList<Pais>();
		try {
			elements=em.createNamedQuery("Pais.findAll",Pais.class).getResultList();
			//elements = em.createNativeQuery("SELECT * FROM REGIONS", Pais.class).getResultList();
			//elements= em.createQuery("SELECT r FROM Pais r", Pais.class).getResultList();
			
		}catch(Exception e) {
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		return elements;
	}

	@Override
	public void crear(Pais element) throws DAOException {
		log.info("[crear]");
		log.debug("Parameters:[pais:"+element+"]");
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			em.persist(element);
			em.getTransaction().commit();
			log.debug("Se ha creado la pais");
		}catch(Exception e) {			
			em.getTransaction().rollback();
			log.debug("Rollback operacion");
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		
	}

	@Override
	public void modificar(Pais element) throws DAOException {
		log.info("[modificar]");
		log.debug("Parameters:[pais:"+element+"]");
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();		
		
		try {
			Pais paisBBDD = em.find(Pais.class, element.getId());
			//Para comprobar si han cambiado la region
			Region region = paisBBDD.getRegion();
			if(paisBBDD.getRegion().getId()!= element.getRegion().getId())
						region = em.find(Region.class, element.getRegion().getId());
			
			em.getTransaction().begin();
			paisBBDD.setNombre(element.getNombre());
			paisBBDD.setRegion(region);
			em.getTransaction().commit();
			log.debug("Se ha creado la pais");
		}catch(Exception e) {			
			em.getTransaction().rollback();
			log.debug("Rollback operacion");
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
		
	}

	@Override
	public void eliminar(String id) throws DAOException {
		log.info("[eliminar]");
		log.debug("Parameters:[id:"+id+"]");
		
		emf=Persistence.createEntityManagerFactory("HR");
		em=emf.createEntityManager();		
		
		try {
			Pais pais = em.find(Pais.class, id);			
			em.getTransaction().begin();
			em.remove(pais);
			em.getTransaction().commit();
			log.debug("Se ha creado la pais");
		}catch(Exception e) {			
			em.getTransaction().rollback();
			log.debug("Rollback operacion");
			log.error("Excepcion:",e);
			throw new DAOException(e);
		}
	}

}
