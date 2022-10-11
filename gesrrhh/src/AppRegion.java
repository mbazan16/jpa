import java.util.List;

import org.apache.log4j.Logger;

import com.jpa.dao.RegionDAO;
import com.jpa.dao.interfaces.DAO;
import com.jpa.entities.Region;
import com.jpa.exceptions.DAOException;

public class AppRegion {
	private final static Logger log = Logger.getLogger(AppRegion.class);

	public static void main(String[] args) {
		log.info("Method:[main]");
		
		DAO<Region,Long> dao= new RegionDAO();
		
		try {
		
			
		log.info("Buscamos region (1):");
		
		Region region = dao.find(1l);
		log.debug("Region:"+region);		
		
		log.info("Buscamos todas las regiones");
		List<Region> regiones= dao.findAll();		
		regiones.forEach(s -> log.debug(s));
		
		log.debug("-----------CREAR--------------");
		
		region = new Region();
		region.setId(53l);
		region.setNombre("Cualquiera ");		
		
		dao.crear(region);
		
		
		log.info("Buscamos todas las regiones");
		 regiones= dao.findAll();		
		regiones.forEach(s -> log.debug(s));
		
		
		log.debug("-----------MODIFICAR--------------");
		
		region.setNombre("Cualquiera otra");
		
		dao.modificar(region);
		
		log.info("Buscamos todas las regiones");
		 regiones= dao.findAll();		
		regiones.forEach(s -> log.debug(s));
		
		log.debug("-----------ELIMINAR--------------");
		
		dao.eliminar(53l);
		
		log.info("Buscamos todas las regiones");
		 regiones= dao.findAll();		
		regiones.forEach(s -> log.debug(s));
		

		} catch (DAOException e) {
			log.error(e.getMensaje(), e);
		}

	}

}
