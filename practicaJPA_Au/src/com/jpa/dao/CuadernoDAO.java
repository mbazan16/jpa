package com.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.jpa.dao.interfaces.DAO;
import com.jpa.entities.Cuaderno;
import com.jpa.exceptions.DAOException;
import com.jpa.exceptions.MensajesExceptions;

/**
 * Gestion del objeto Cuaderno con la bbdd
 * 
 * @author formacion
 *
 */
public class CuadernoDAO implements DAO<Long, Cuaderno> {

	private final static Logger log = Logger.getLogger(CuadernoDAO.class);

	EntityManagerFactory emf;

	EntityManager manager;

	/**
	 * Método para encontrar un Cuaderno por su id
	 * 
	 * @param id Identificador del Cuaderno
	 * @return objeto Cuaderno
	 * @throws DAOException
	 */
	@Override
	public Cuaderno find(Long id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parmetros:[Long id:" + id + "]");

		Cuaderno element = null;

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

	/**
	 * Método para encontrar tododos los Cuadernos de la base de datos
	 * 
	 * @return Una Lista de Cuadernos
	 * @throws DAOException
	 */
	@Override
	public List<Cuaderno> findAll() throws DAOException {
		log.info("Method:[findAll]");

		List<Cuaderno> elements = new ArrayList<Cuaderno>();

		try {
			init();
			// elements = tipo.createNamedQuery("Cuaderno.findAll",
			// Cuaderno.class)
			// .getResultList();
			String sql = "select c from Cuaderno c";

			TypedQuery<Cuaderno> query = manager.createQuery(sql, Cuaderno.class);

			elements = query.getResultList();

			elements.forEach(c -> log.debug(c));

		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return elements;
	}

	/**
	 * Método para crear un Cuaderno de la base de datos
	 * 
	 * @param element objeto de tipo Cuaderno
	 * @throws DAOException
	 */
	@Override
	public void crear(Cuaderno element) throws DAOException {
		log.info("Method:[crear]");
		log.debug("Parmetros:[Cuaderno element:" + element + "]");

		try {
			init();
			validarCrear(element);

			try {
				log.debug("[crear]Iniciamos transacción");
				manager.getTransaction().begin();
				manager.persist(element);
				manager.getTransaction().commit();
				log.debug("[crear]Commit - Creamos cuaderno");
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
	 * Método para modificar un Cuaderno de la base de datos
	 * 
	 * @param element objeto de tipo Cuaderno
	 * @throws DAOException
	 */
	@Override
	public void modificar(Cuaderno element) throws DAOException {
		log.info("Method:[modificar]");
		log.debug("Parmetros:[Cuaderno element:" + element + "]");
		try {
			init();
			Cuaderno cuadernoBBDD = validarModificar(element);

			try {
				log.debug("[modificar]Iniciamos transacción");
				manager.getTransaction().begin();
				cuadernoBBDD.setId(element.getId());
				cuadernoBBDD.setNombre(element.getNombre());
				cuadernoBBDD.setTipo(element.getTipo());
				manager.getTransaction().commit();
				log.debug("[modificar]Commit - Modificamos cuaderno");
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
	 * Método para eliminar un Cuaderno de la base de datos
	 * 
	 * @param id Identificador de Cuaderno
	 * @throws DAOException
	 */
	@Override
	public void eliminar(Long id) throws DAOException {
		log.info("Method:[eliminar]");
		log.debug("Parmetros:[Long id:" + id + "]");

		try {
			init();
			Cuaderno element = validarEliminar(id);

			try {
				log.debug("[eliminar]Iniciamos transacción");
				manager.getTransaction().begin();
				manager.remove(element);
				manager.getTransaction().commit();
				log.debug("[eliminar]Commit - Eliminamos cuaderno+" + element);
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
	 * EntityTipoFactory y EntityTipo
	 */
	private void init() {
		log.info("Method:[private init]");

		if (emf == null)
			emf = Persistence.createEntityManagerFactory("UPCuaderno");
		log.debug("[emf]:" + emf);
		if (manager == null || !manager.isOpen())
			manager = emf.createEntityManager();
		log.debug("[tipo]:" + manager);
	}

	/**
	 * Validaciones para la acción crear Cuaderno. Se comprueba que no existe el
	 * cuaderno y que el nombre esta registrado en la BBDD Si exite el
	 * tipo, también se comprueba su existencia
	 * 
	 * @param element
	 * @throws DAOException
	 */
	private void validarCrear(Cuaderno element) throws DAOException {
		log.info("Method:[private validarCrear]");
		log.debug("Parmetros:[Cuaderno element:" + element + "]");

		/* Esto no hace falta porque no  sabemos cual es el id antes de crearlo
		 * Cuaderno cuadernoBBDD = findBBDD(element.getId());
		 * 
		 * if (cuadernoBBDD != null) throw new
		 * DAOException(MensajesExceptions.EXISTE_DEPARTAMENTO);
		 */

		comprobarNombre(element.getNombre());
		

	}

	/**
	 * Validaciones para la acción modificar Cuaderno. Se comprueba que existe
	 * el cuaderno, que el cuaderno a modificar no es igualque el existente
	 * y que la nombre esta registrada en la BBDD Si exite el tipo, también se
	 * comprueba su existencia
	 * 
	 * @param element
	 * @throws DAOException
	 */
	private Cuaderno validarModificar(Cuaderno element) throws DAOException {
		log.info("Method:[private validarModificar]");
		log.debug("Parmetros:[Cuaderno element:" + element + "]");

		Cuaderno cuadernoBBDD = findBBDD(element.getId());
		if (cuadernoBBDD == null)
			throw new DAOException(MensajesExceptions.NO_EXISTE_CUADERNO);

		if (!cuadernoBBDD.equals(element)) {
			comprobarNombre(element.getNombre());

		}
		return cuadernoBBDD;

	}

	/**
	 * Validaciones para la acción modificar Cuaderno. Se comprueba que existe
	 * el cuaderno
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	private Cuaderno validarEliminar(Long id) throws DAOException {
		log.info("Method:[private validarEliminar]");
		log.debug("Parmetros:[Long id:" + id + "]");

		Cuaderno cuadernoBBDD = findBBDD(id);
		if (cuadernoBBDD == null)
			throw new DAOException(MensajesExceptions.NO_EXISTE_CUADERNO);

		return cuadernoBBDD;
	}

	/**
	 * Se compureba que el identificador de nombre identifica un Nombre en
	 * BBDD
	 * 
	 * @param string
	 * @throws DAOException
	 */
	private void comprobarNombre(String nombre) throws DAOException {
		log.info("Method:[private comprobarDirecciónn]");
		log.debug("Parmetros:[Cadena nombre:" + nombre + "]");

		TypedQuery<Cuaderno> query = manager
										.createNamedQuery("Cuaderno.findByNombre", Cuaderno.class)
										.setParameter("nombre", nombre);
		try {
		Cuaderno cuaderno = query.getSingleResult();
		}catch(NoResultException ne) {
			throw new DAOException(MensajesExceptions.EXISTE_CUADERNO);
		}
		
	}

	/**
	 * Se compureba que el identificador de tipo identifica un Tipo en BBDD
	 * 
	 * @param idTipo
	 * @throws DAOException
	 */
	private void comprobarTipo(Long idTipo) throws DAOException {
		log.info("Method:[private comprobarTipo]");
		log.debug("Parmetros:[Long idTipo:" + idTipo + "]");
		if (idTipo != null) {
			Cuaderno e = manager.find(Cuaderno.class, idTipo);
			if (e == null)
				throw new DAOException(MensajesExceptions.NO_EXISTE_TIPO);
		}

	}

	/**
	 * Se extrae un Cuaderno por su id de la BBDD
	 * 
	 * @param idNombre
	 * @throws DAOException
	 */
	private Cuaderno findBBDD(Long id) throws DAOException {
		log.info("Method:[private findBBDD ]");
		log.debug("Parmetros:[Long id:" + id + "]");

		Cuaderno element = null;

		try {
			element = manager.find(Cuaderno.class, id);
			log.debug("[private findBBDD ][element]:" + element);

		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);

		}

		return element;
	}
}
