import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.jpa.entities.Empleado;

public class PruebaFueraEstructura {
	private final static Logger log = Logger.getLogger(PruebaFueraEstructura.class);


	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("HR");
		EntityManager em=emf.createEntityManager();
		
		Empleado empleado = em.find(Empleado.class, 148l);
		log.debug("Empleado:"+empleado);
		
		log.debug("Ciudad del departamento del Empleado:"+empleado.getDepartamento().getDireccion().getCiudad());
		
		log.debug("Region del departamento del Empleado:"+empleado.getDepartamento().getDireccion().getPais().getRegion().getNombre());
	}

}
