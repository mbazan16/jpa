package com.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.jpa.dao.interfaces.IDepartamentoDAO;
import com.jpa.entities.Departamento;
import com.jpa.entities.Direccion;
import com.jpa.entities.Empleado;
import com.jpa.exceptions.DAOException;
import com.jpa.exceptions.MensajesExceptions;

/**
 * Gestion del objeto Departamento con la bbdd
 * @author formacion
 *
 */
public class DepartamentoDAO implements IDepartamentoDAO{

	private final static Logger log = Logger.getLogger(DepartamentoDAO.class);

	EntityManagerFactory emf;

	EntityManager manager;	
	
	


	/**
	 * M�todo para encontrar un Departamento por su id 
	 * @param id Identificador del Departamento
	 * @return  objeto Departamento
	 * @throws DAOException
	 */
	@Override
	public Departamento find(Long id) throws DAOException {
		log.info("Method:[find]");
		log.debug("Parmetros:[Long id:" + id+"]");

		Departamento element = null;

		try {
			init();
			element =findBBDD(id);

		}catch (DAOException daoe) {
			throw daoe;
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);

		}

		return element;
	}

	/**
	 * M�todo para encontrar tododos los Departamentos de la base de datos
	 * @return Una Lista de Departamentos
	 * @throws DAOException
	 */
	@Override
	public List<Departamento> findAll() throws DAOException {
		log.info("Method:[findAll]");

		List<Departamento> elements = new ArrayList<Departamento>();

		try {
			init();
			
			elements = manager.createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
			elements.forEach(s->log.debug(s));
			
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return elements;
	}

	@Override
	public List<Departamento> buscarPorJefeDepartmento(Long idJefeDepartamento) throws DAOException {
		log.info("Method:[buscarPorJefeDepartmento]");
		log.debug("Parmetros:[Long idJefeDepartamento:" + idJefeDepartamento+"]");

		List<Departamento> elements = new ArrayList<Departamento>();

		try {
			init();
			
			elements = manager.createNamedQuery("Departamento.findByJefeDepartamento", Departamento.class)
					.setParameter(1,idJefeDepartamento).getResultList();
			elements.forEach(s->log.debug(s));
			
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return elements;
	}

	@Override
	public List<Departamento> buscarPorDireccion(Long idDireccion) throws DAOException {
		log.info("Method:[buscarPorDireccion]");
		log.debug("Parmetros:[Long idDireccion:" + idDireccion+"]");

		List<Departamento> elements = new ArrayList<Departamento>();

		try {
			init();
			String query="SELECT d FROM Departamento d WHERE d.direccion.id= :idDireccion";
			
			elements = manager.createQuery(query,Departamento.class)
					.setParameter("idDireccion",idDireccion).getResultList();
			elements.forEach(s->log.debug(s));
			
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return elements;
	}

	@Override
	public Departamento buscarPorEmpleado(Long idEmpleado) throws DAOException {
		log.info("Method:[findAll]");
		log.debug("Parmetros:[Long idEmpleado:" + idEmpleado+"]");

		Departamento element = null;

		try {
			init();
			
			element = manager.createNamedQuery("Departamento.findbyEmpleado", Departamento.class)
					.setParameter("pepe",idEmpleado).getSingleResult();
			log.debug("[Departamento:" + element+"]");
			
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return element;
	}
	@Override
	public Long darNumeroEmpleadosDepartamento(Long idDepartamento) throws DAOException {
		log.info("Method:[darNumeroEmpleadosDepartamento]");
		log.debug("Parmetros:[Long idDepartamento:" + idDepartamento+"]");

		Long numEmpleados = null;

		try {
			init();
			
			numEmpleados = manager.createNamedQuery("Departamento.countEmpleados", Long.class)
					.setParameter("id",idDepartamento).getSingleResult();
			log.debug("[numEmpleados:" + numEmpleados+"]");
			
		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

		return numEmpleados;
	}

	/**
	 * M�todo para crear un Departamento de la base de datos
	 * @param element objeto de tipo Departamento
	 * @throws DAOException
	 */
	@Override
	public void crear(Departamento element) throws DAOException {
		log.info("Method:[crear]");
		log.debug("Parmetros:[Departamento element:" + element+"]");

		try {
			init();
			validarCrear(element);

			try {
				log.debug("[crear]Iniciamos transacci�n");
				manager.getTransaction().begin();
				manager.persist(element);
				manager.getTransaction().commit();
				log.debug("[crear]Commit - Creamos departamento");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[crear]Rollback");
				throw new DAOException(e);
			}

		} catch (DAOException daoe) {
			throw daoe;
		}catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

	}


	/**
	 * M�todo para modificar un Departamento de la base de datos
	 * @param element objeto de tipo Departamento
	 * @throws DAOException
	 */
	@Override
	public void modificar(Departamento element) throws DAOException {
		log.info("Method:[modificar]");
		log.debug("Parmetros:[Departamento element:" + element+"]");
		try {
			init();
			Departamento departamentoBBDD = validarModificar(element);

			try {
				log.debug("[modificar]Iniciamos transacci�n");
				manager.getTransaction().begin();
				departamentoBBDD.setNombre(element.getNombre());				
				//departamentoBBDD.get(element.getIdDireccion());
				//departamentoBBDD.setIdManager(element.getIdManager());
				manager.getTransaction().commit();
				log.debug("[modificar]Commit - Modificamos departamento");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[modificar]Rollback");
				throw new DAOException(e);
			}

		} catch (DAOException daoe) {
			throw daoe;
		}catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}


	}


	/**
	 * M�todo para eliminar un Departamento de la base de datos
	 * @param id Identificador de Departamento
	 * @throws DAOException
	 */
	@Override
	public void eliminar(Long id) throws DAOException {
		log.info("Method:[eliminar]");
		log.debug("Parmetros:[Long id:" + id+"]");

		try {
			init();
			Departamento element = validarEliminar(id);

			try {
				log.debug("[eliminar]Iniciamos transacci�n");
				manager.getTransaction().begin();
				manager.remove(element);
				manager.getTransaction().commit();
				log.debug("[eliminar]Commit - Eliminamos departamento");
			} catch (Exception e) {
				log.error("Error", e);
				manager.getTransaction().rollback();
				log.debug("[eliminar]Rollback");
				throw new DAOException(e);
			}

		} catch (DAOException daoe) {
			throw daoe;
		}catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);
		}

	}



	/**
	 * M�todo de inicializaci�n de la clase
	 * Se inicializa dos objetos : EntityManagerFactory y EntityManager
	 */
	private void init() {
		log.info("Method:[private init]");

		if(emf==null) emf = Persistence.createEntityManagerFactory("HR");
		log.debug("[emf]:"+emf);
		if(manager== null) manager =  emf.createEntityManager();
		log.debug("[manager]:"+manager);
	}

	/**
	 * Validaciones para la acci�n crear Departamento.
	 * Se comprueba que no existe el departamento
	 * y que la direccion esta registrada en la BBDD
	 * Si exite el manager, tambi�n se comprueba su existencia
	 * 
	 * @param element
	 * @throws DAOException
	 */
	private void validarCrear(Departamento element)  throws DAOException {
		log.info("Method:[private validarCrear]");
		log.debug("Parmetros:[Departamento element:" + element+"]");

		Departamento departamentoBBDD = findBBDD(element.getId());

		if(departamentoBBDD != null) throw new DAOException(MensajesExceptions.EXISTE_DEPARTAMENTO);

		comprobarDireccion(element.getDireccion().getId());
		comprobarManager(element.getIdManager());

	}
	/**
	 * Validaciones para la acci�n modificar Departamento.
	 * Se comprueba que existe el departamento,
	 * que el departamento a modificar no es igualque el existente
	 * y que la direccion esta registrada en la BBDD
	 * Si exite el manager, tambi�n se comprueba su existencia
	 * 
	 * @param element
	 * @throws DAOException
	 */
	private Departamento validarModificar(Departamento element)  throws DAOException{
		log.info("Method:[private validarModificar]");
		log.debug("Parmetros:[Departamento element:" + element+"]");

		Departamento departamentoBBDD = findBBDD(element.getId());		
		if(departamentoBBDD == null) throw new DAOException(MensajesExceptions.NO_EXISTE_DEPARTAMENTO);

		if(!departamentoBBDD.equals(element)) {
			comprobarDireccion(element.getDireccion().getId());
			comprobarManager(element.getIdManager());

		}
		return departamentoBBDD;

	}


	/**
	 * Validaciones para la acci�n modificar Departamento.
	 * Se comprueba que existe el departamento
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	private Departamento validarEliminar(Long id)  throws DAOException{
		log.info("Method:[private validarEliminar]");
		log.debug("Parmetros:[Long id:" + id+"]");

		Departamento departamentoBBDD = findBBDD(id);		
		if(departamentoBBDD == null) throw new DAOException(MensajesExceptions.NO_EXISTE_DEPARTAMENTO);

		return departamentoBBDD;
	}


	/**
	 * Se compureba que el identificador de direcci�n identifica
	 * una Direcci�n en BBDD
	 * @param idDireccion
	 * @throws DAOException
	 */
	private void comprobarDireccion(Long idDireccion) throws DAOException{
		log.info("Method:[private comprobarDirecci�nn]");
		log.debug("Parmetros:[Long idDireccion:" + idDireccion+"]");

		Direccion localizacion = manager.find(Direccion.class, idDireccion);
		if (localizacion == null)
			throw new DAOException(MensajesExceptions.NO_EXISTE_DIRECCION);

	}

	/**
	 * Se compureba que el identificador de manager identifica
	 * un Empleado en BBDD
	 * @param idDireccion
	 * @throws DAOException
	 */
	private void comprobarManager(Long idManager)throws DAOException {
		log.info("Method:[private comprobarManager]");
		log.debug("Parmetros:[Long idManager:" + idManager+"]");
		if (idManager != null) {
			Empleado e = manager.find(Empleado.class, idManager);
			if (e == null)
				throw new DAOException(MensajesExceptions.NO_EXISTE_EMPLEADO);
		}

	}


	/**
	 * Se extrae un Departamente por su id de la BBDD
	 * @param idDireccion
	 * @throws DAOException
	 */
	private Departamento findBBDD(Long id) throws DAOException {
		log.info("Method:[private findBBDD ]");
		log.debug("Parmetros:[Long id:" + id+"]");

		Departamento element = null;

		try {
			element = manager.find(Departamento.class, id);
			log.debug("[private findBBDD ][element]:"+element);

		} catch (Exception e) {
			log.error("Error", e);
			throw new DAOException(e);

		}

		return element;
	}

}
