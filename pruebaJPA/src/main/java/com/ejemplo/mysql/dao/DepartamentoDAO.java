package com.ejemplo.mysql.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.ejemplo.mysql.dao.exceptions.DAOException;
import com.ejemplo.mysql.dao.interfaces.IDAO;
import com.ejemplo.mysql.dao.interfaces.IDAODepartamento;
import com.ejemplo.mysql.data.Departamento;

/**
 * Clase de acceso a datos para gestionar la entidad Departamento
 * @author Mañanas
 *
 */
public class DepartamentoDAO implements IDAODepartamento {
	 
	private final static Logger log = Logger.getLogger(DepartamentoDAO.class);
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public DepartamentoDAO() {
		
	}
	

	// Metodos read
	/**
	 * Lectura de todos los departamentos
	 */
	@Override
	public List<Departamento> findAll() throws DAOException {
		log.info("findAll");
		
		List<Departamento> departamentos;

		try {
			init();
			
			//Query nativa -- en sql
			/*
			 * String querySQL = "SELECT * FROM DEPARTMENTS";
			 * 
			 * Query query= em.createNativeQuery(querySQL, Departamento.class);
			 * 
			 * departamentos=query.getResultList();
			 */
			
			//Query jpql
			
			/*
			 * String queryJPQL = "SELECT d FROM Departamento d"; TypedQuery<Departamento>
			 * query =em.createQuery(queryJPQL,Departamento.class);
			 * departamentos=query.getResultList();
			 */
			
			//Named query
			
			TypedQuery<Departamento> query = em.createNamedQuery("Departamento.findAll", Departamento.class);
			departamentos=query.getResultList();
			
			
		} catch (Exception e) {
			log.error("Error general",e);
			throw new DAOException(CodigoError.EXCEPCION_GENERAL);
		}
		return departamentos;
	}

	/**
	 * Lectura de un departamento por su identificador
	 * @param id identificador del Departamento
	 */
	@Override
	public Departamento findById(Integer id) throws DAOException {
		log.info("findById");
		log.debug("id:"+id);
		
		Departamento departamento=null;

		try {
			init();
			departamento = em.find(Departamento.class, id);
			
		} catch (Exception e) {
			log.error("Error general",e);
			throw new DAOException(CodigoError.EXCEPCION_GENERAL);
		}
		return departamento;
	}

	@Override
	public List<Departamento> findbyDireccionId(Integer direccionId) throws DAOException {
		log.info("findbyDireccionId");
		log.debug("direccionId"+direccionId);
		
		List<Departamento> departamentos = new ArrayList<Departamento>();

		try {
			init();
			//Query Nativa
			/*
			 * String querySQL="SELECT * FROM DEPARTMENTS d, LOCATIONS l " +
			 * "WHERE d.location_id = l.location_id AND l.location_id=? "; Query query=
			 * em.createNativeQuery(querySQL, Departamento.class) .setParameter(1,
			 * locationId); departamentos=query.getResultList();
			 */
			//Query JPQL
			String queryJPQL ="SELECT d FROM Departamento d WHERE d.direccion.id= :id";
			TypedQuery<Departamento> query =em.createQuery(queryJPQL,Departamento.class)
					.setParameter("id", direccionId);
			departamentos=query.getResultList();
			
			
		} catch (Exception e) {
			log.error("Error general",e);
			throw new DAOException(CodigoError.EXCEPCION_GENERAL);
		}
		return departamentos;
	}


	@Override
	public List<Departamento> findbyDireccionCiudad(String ciudad) throws DAOException {
		log.info("findbyDireccionCiudad");
		log.debug("ciudad"+ciudad);
		
		List<Departamento> departamentos = new ArrayList<Departamento>();

		try {
			init();
			
			//Query JPQL
			String queryJPQL ="SELECT d FROM Departamento d WHERE d.direccion.ciudad =:ciudad";
			TypedQuery<Departamento> query =em.createQuery(queryJPQL,Departamento.class)
					.setParameter("ciudad", ciudad);
			departamentos=query.getResultList();
			
			
		} catch (Exception e) {
			log.error("Error general",e);
			throw new DAOException(CodigoError.EXCEPCION_GENERAL);
		}
		return departamentos;
	}


	// Hacemos el insert, create. Es una QUERY dinámica porque insertamos variables
		// (prepareStatement)
		// usamos executeUpdate para insert update y delete.
	/**
	 * Se crea un departamento 
	 */	
	@Override
	public void create(Departamento departamento) throws DAOException {
		log.info("create");
		log.debug("Departamento:"+departamento.toString());
		

		try {
			init();
			em.persist(departamento);
			
		} catch (Exception e) {
			log.error("Error general",e);
			throw new DAOException(CodigoError.EXCEPCION_GENERAL);
		}
	}
	/**
	 * Se modifica un departamento 
	 * @param Departamento Bean con los datos del departamento
	 * @see Departamento
	 */	
	@Override
	public void update(Departamento departamento) throws DAOException {
		log.info("update");
		log.debug("Departamento:"+departamento.toString());
		
		try {
			init();
			em.merge(departamento);
			
		} catch (Exception e) {
			log.error("Error general",e);
			throw new DAOException(CodigoError.EXCEPCION_GENERAL);
		}
	}
	/**
	 * Se elimina un departamento por su identificador
	 * @param id Identificador del departamento
	 */	
	@Override
	public void delete(Integer id) throws DAOException {
		log.info("delete");
		log.debug("id:"+id);

		try {
			init();
			Departamento departamento = em.find(Departamento.class, id);
			em.remove(departamento);
			  
		} catch (Exception e) {
			log.error("Error general",e);
			throw new DAOException(CodigoError.EXCEPCION_GENERAL);
		}
	}



	private void init() {
		if(this.emf==null) this.emf=Persistence.createEntityManagerFactory("pruebaJPA");
	    if(this.em==null) this.em=emf.createEntityManager();
	}

	
	

}
