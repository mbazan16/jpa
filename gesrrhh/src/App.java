import java.util.List;

import org.apache.log4j.Logger;

import com.jpa.dao.DepartamentoDAO;
import com.jpa.dao.interfaces.DAO;
import com.jpa.entities.Departamento;
import com.jpa.exceptions.DAOException;

public class App {
	private final static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		log.info("Method:[main]");

		log.debug("Creamos objeto departamento");
		Departamento departamento = new Departamento();
		departamento.setId(280L);
		departamento.setNombre("Nuevo Departamento");
		departamento.setIdDireccion(1000L);
		departamento.setIdManager(110L);

		DAO<Long, Departamento> departamentoDAO = new DepartamentoDAO();
		log.debug("[main] departamentoDAO:" + departamentoDAO);
		try {

			log.debug("[main]Buscamos los departamento");
			List<Departamento> departamentos = departamentoDAO.findAll();
			log.debug("[main]Mostramos todos los departamentos");
			departamentos.forEach(d -> log.debug("[mai] Departamento:" + d));

			log.debug("[main]Buscamos departamento");
			Departamento d = departamentoDAO.find(10L);
			log.debug("[main]Mostramos departamento");
			log.debug("[mai] Departamento:" + d);

			log.debug("[main]Creamos objeto departamento");
			departamentoDAO.crear(departamento);
			log.debug("[main]El departamento se ha creado");

			departamento.setNombre("Cambio nombre");

			log.debug("[main]Modificamos objeto departamento");
			departamentoDAO.modificar(departamento);
			log.debug("[main]El departamento se ha modificado");

			log.debug("[main]Eliminamos objeto departamento");
			departamentoDAO.eliminar(280L);
			log.debug("[main]El departamento se ha eliminado");
			
			
		} catch (DAOException e) {
			log.error(e.getMensaje(), e);
		}

	}

}
