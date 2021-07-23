

import java.util.List;

import org.apache.log4j.Logger;

import com.jpa.dao.CuadernoDAO;
import com.jpa.dao.interfaces.DAO;
import com.jpa.entities.Cuaderno;
import com.jpa.exceptions.DAOException;

public class App {
	private final static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		log.info("Method:[main]");

		log.debug("Creamos objeto cuaderno");
		Cuaderno cuaderno = new Cuaderno();
		cuaderno.setId(01L);
		cuaderno.setNombre("Cuaderno01");
		cuaderno.setTipo(10L);

		DAO<Long, Cuaderno> cuadernoDAO = new CuadernoDAO();
		log.debug("[main] cuadernoDAO:" + cuadernoDAO);
		try {

			log.debug("[main]Buscamos los cuaderno");
			List<Cuaderno> cuadernos = cuadernoDAO.findAll();
			log.debug("[main]Mostramos todos los cuadernos");
			cuadernos.forEach(d -> log.debug("[mai] Cuaderno:" + d));

			log.debug("[main]Buscamos cuaderno");
			Cuaderno c = cuadernoDAO.find(01L);
			log.debug("[main]Mostramos cuaderno");
			log.debug("[main] Cuaderno:" + c);

			log.debug("[main]Creamos objeto cuaderno");
			cuadernoDAO.crear(cuaderno);
			log.debug("[main]El cuaderno se ha creado");

			cuaderno.setNombre("Cambio nombre");

			log.debug("[main]Modificamos objeto cuaderno");
			cuadernoDAO.modificar(cuaderno);
			log.debug("[main]El cuaderno se ha modificado");

			log.debug("[main]Eliminamos objeto cuaderno");
			cuadernoDAO.eliminar(01L);
			log.debug("[main]El cuaderno se ha eliminado");
			
			
		} catch (DAOException e) {
			log.error(e.getMensaje(), e);
		}

	}

}
