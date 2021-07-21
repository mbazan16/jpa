package com.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.jpa.dao.interfaces.DAO;
import com.jpa.dao.interfaces.IRepositoryDireccion;
import com.jpa.entities.Direccion;
import com.jpa.entities.Empleado;
import com.jpa.entities.Direccion;
import com.jpa.exceptions.DAOException;
import com.jpa.exceptions.MensajesExceptions;

/**
 * Gestion del objeto Direccion con la bbdd
 * 
 * @author formacion
 *
 */
public class DireccionRepository implements IRepositoryDireccion {

	private final static Logger log = Logger.getLogger(DireccionRepository.class);

	EntityManagerFactory emf;

	EntityManager manager;

	/**
	 * Método para encontrar un Direccion por su id
	 * 
	 * @param id Identificador del Direccion
	 * @return objeto Direccion
	 * @throws DAOException
	 */
	@Override
	public Direccion find(Long id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parmetros:[Long id:" + id + "]");

		Direccion element = null;

		try {
			init();
			element = findBBDD(id);

		} catch (DAOException daoe) {
			throw daoe;
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);

		}

		return element;
	}

	@Override
	public Direccion findOneByDepartamento(Long idDepartamento) throws DAOException {
		log.info("Method:[findOneByDepartamento]");

		Direccion direccion;

		try {
			init();
			
			TypedQuery<Direccion> typeQuery = manager.createNamedQuery("Direccion.findOneByDepartamento", Direccion.class)
					 .setParameter("id", idDepartamento);
			
				
			 direccion = typeQuery.getSingleResult();
			

			log.debug("Direccion del departamento:"+direccion);

		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return direccion;
	}

	/**
	 * Método para encontrar tododos los Direcciones de la base de datos
	 * 
	 * @return Una Lista de Direcciones
	 * @throws DAOException
	 */
	@Override
	public List<Direccion> findAll() throws DAOException {
		log.info("Method:[findAll]");

		List<Direccion> elements = new ArrayList<Direccion>();

		try {
			init();
			// elements = manager.createNamedQuery("Direccion.findAll",
			// Direccion.class)
			// .getResultList();
			String sql = "select d from Direccion d";

			TypedQuery<Direccion> query = manager.createQuery(sql, Direccion.class);

			elements = query.getResultList();

			elements.forEach(d -> log.debug(d));

		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return elements;
	}
	

	

	@Override
	public List<Direccion> findAllByPais(String idPais) throws DAOException {
		log.info("Method:[findAllByPais]");

		List<Direccion> elements = new ArrayList<Direccion>();

		try {
			init();
			 elements = manager.createNamedQuery("Direccion.findAllByPais", Direccion.class)
					// .setParameter(1, idPais)
					 .setParameter("id", idPais)
					 .getResultList();
			

			elements.forEach(d -> log.debug(d));

		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return elements;
	}

	/**
	 * Método para crear un Direccion de la base de datos
	 * 
	 * @param element objeto de tipo Direccion
	 * @throws DAOException
	 */
	@Override
	public void crear(Direccion element) throws DAOException {
		log.info("Method:[crear]");
		log.debug("Parmetros:[Direccion element:" + element + "]");

		try {
			init();
			validarCrear(element);

			try {
				log.debug("[crear]Iniciamos transacción");
				manager.getTransaction().begin();
				manager.persist(element);
				manager.getTransaction().commit();
				log.debug("[crear]Commit - Creamos direccion");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[crear]Rollback");
				throw new DAOException(e);
			}

		} catch (DAOException daoe) {
			throw daoe;
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

	}

	/**
	 * Método para modificar un Direccion de la base de datos
	 * 
	 * @param element objeto de tipo Direccion
	 * @throws DAOException
	 */
	@Override
	public void modificar(Direccion element) throws DAOException {
		log.info("Method:[modificar]");
		log.debug("Parmetros:[Direccion element:" + element + "]");
		try {
			init();
			Direccion direccionBBDD = validarModificar(element);

			try {
				log.debug("[modificar]Iniciamos transacción");
				manager.getTransaction().begin();
				direccionBBDD.setCalle(element.getCalle());
				direccionBBDD.setCiudad(element.getCiudad());
				direccionBBDD.setCodigoPostal(element.getCodigoPostal());
				direccionBBDD.setIdPais(element.getIdPais());
				direccionBBDD.setProvincia(element.getProvincia());
				manager.getTransaction().commit();
				log.debug("[modificar]Commit - Modificamos direccion");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[modificar]Rollback");
				throw new DAOException(e);
			}

		} catch (DAOException daoe) {
			throw daoe;
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

	}

	/**
	 * Método para eliminar un Direccion de la base de datos
	 * 
	 * @param id Identificador de Direccion
	 * @throws DAOException
	 */
	@Override
	public void eliminar(Long id) throws DAOException {
		log.info("Method:[eliminar]");
		log.debug("Parmetros:[Long id:" + id + "]");

		try {
			init();
			Direccion element = validarEliminar(id);

			try {
				log.debug("[eliminar]Iniciamos transacción");
				manager.getTransaction().begin();
				manager.remove(element);
				manager.getTransaction().commit();
				log.debug("[eliminar]Commit - Eliminamos direccion+" + element);
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[eliminar]Rollback");
				throw new DAOException(e);
			}

		} catch (DAOException daoe) {
			throw daoe;
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

	}

	/**
	 * Método de inicialización de la clase Se inicializa dos objetos :
	 * EntityManagerFactory y EntityManager
	 */
	private void init() {
		log.info("Method:[private init]");

		if (emf == null)
			emf = Persistence.createEntityManagerFactory("HR");
		log.debug("[emf]:" + emf);
		if (manager == null || !manager.isOpen())
			manager = emf.createEntityManager();
		log.debug("[manager]:" + manager);
	}

	/**
	 * Validaciones para la acción crear Direccion. Se comprueba que no existe el
	 * direccion y que la direccion esta registrada en la BBDD Si exite el
	 * manager, también se comprueba su existencia
	 * 
	 * @param element
	 * @throws DAOException
	 */
	private void validarCrear(Direccion element) throws DAOException {
		log.info("Method:[private validarCrear]");
		log.debug("Parmetros:[Direccion element:" + element + "]");

		Direccion direccionBBDD = findBBDD(element.getId());

		if (direccionBBDD != null)
			throw new DAOException(MensajesExceptions.EXISTE_DEPARTAMENTO);	}

	/**
	 * Validaciones para la acción modificar Direccion. Se comprueba que existe
	 * el direccion, que el direccion a modificar no es igualque el existente
	 * y que la direccion esta registrada en la BBDD Si exite el manager, también se
	 * comprueba su existencia
	 * 
	 * @param element
	 * @throws DAOException
	 */
	private Direccion validarModificar(Direccion element) throws DAOException {
		log.info("Method:[private validarModificar]");
		log.debug("Parmetros:[Direccion element:" + element + "]");

		Direccion direccionBBDD = findBBDD(element.getId());
		if (direccionBBDD == null)
			throw new DAOException(MensajesExceptions.NO_EXISTE_DEPARTAMENTO);

		
		return direccionBBDD;

	}

	/**
	 * Validaciones para la acción modificar Direccion. Se comprueba que existe
	 * el direccion
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	private Direccion validarEliminar(Long id) throws DAOException {
		log.info("Method:[private validarEliminar]");
		log.debug("Parmetros:[Long id:" + id + "]");

		Direccion direccionBBDD = findBBDD(id);
		if (direccionBBDD == null)
			throw new DAOException(MensajesExceptions.NO_EXISTE_DEPARTAMENTO);

		return direccionBBDD;
	}

	

	/**
	 * Se extrae un Departamente por su id de la BBDD
	 * 
	 * @param idDireccion
	 * @throws DAOException
	 */
	private Direccion findBBDD(Long id) throws DAOException {
		log.info("Method:[private findBBDD ]");
		log.debug("Parmetros:[Long id:" + id + "]");

		Direccion element = null;

		try {
			element = manager.find(Direccion.class, id);
			log.debug("[private findBBDD ][element]:" + element);

		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);

		}

		return element;
	}

}
