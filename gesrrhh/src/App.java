import java.util.List;

import org.apache.log4j.Logger;

import com.jpa.dao.DepartamentoDAO;
import com.jpa.dao.interfaces.IDepartamentoDAO;
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
		departamento.getDireccion().setId(1000L);
		departamento.setIdManager(110L);

		IDepartamentoDAO departamentoDAO = new DepartamentoDAO();
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

			log.debug("[main]Buscamos por Jefe Departamento (200)");

			List<Departamento> departamentosJefeDepartamento = departamentoDAO.buscarPorJefeDepartmento(200l);

			log.debug("[main]Mostramos todos los departamentos del Jefe de Departamento (200):");
			departamentosJefeDepartamento.forEach(s -> log.debug("[mai] Departamento:" + s));

			log.debug("[main]Buscamos por Empleado (140)");

			Departamento departamentoEmpleado = departamentoDAO.buscarPorEmpleado(140l);

			log.debug("[main]Mostramos departamento del empleado(140)");
			log.debug("[main] Departamento:" + departamentoEmpleado);

			log.debug("[main]Buscamos el numero de empleados que tiene un departamento (80)");

			Long numEmpleados = departamentoDAO.darNumeroEmpleadosDepartamento(80l);
			log.debug("[main][numEmpleados:" + numEmpleados + "]");
			

			log.debug("[main]Buscamos por Direccion (1700)");

			List<Departamento> departamentosDireccion = departamentoDAO.buscarPorDireccion(1700l);

			log.debug("[main]Mostramos todos los departamentos de la direccion (1700):");
			departamentosDireccion.forEach(s -> log.debug("[mai] Departamento:" + s));


		} catch (DAOException e) {
			log.error(e.getMensaje(), e);
		}

	}

}
