import java.util.List;

import org.apache.log4j.Logger;

import com.jpa.dao.PaisDAO;
import com.jpa.dao.RegionDAO;
import com.jpa.dao.interfaces.DAO;
import com.jpa.entities.Pais;
import com.jpa.entities.Region;
import com.jpa.exceptions.DAOException;

public class AppPais {
	private final static Logger log = Logger.getLogger(AppPais.class);

	public static void main(String[] args) {
		log.info("Method:[main]");
		
		DAO<Pais,String> dao= new PaisDAO();
		
		DAO<Region,Long> regionDAO= new RegionDAO();
		
		try {
		
			
		log.info("Buscamos pais (US):");
		
		Pais pais = dao.find("US");
		log.debug("Pais:"+pais);		
		
		log.info("Buscamos todos los paises");
		List<Pais> paises= dao.findAll();		
		paises.forEach(s -> log.debug(s));
		
		log.debug("-----------CREAR--------------");
		
		pais = new Pais();
		pais.setId("ES");
		pais.setNombre("Spain ");		
		pais.setRegion(regionDAO.find(1l));
		
		dao.crear(pais);
		
		
		log.info("Buscamos todos los paises");
		 paises= dao.findAll();		
		paises.forEach(s -> log.debug(s));
		
		
		log.debug("-----------MODIFICAR--------------");
		
		pais.setNombre("España");
		pais.setRegion(regionDAO.find(2l));
		
		dao.modificar(pais);
		
		log.info("Buscamos todos los paises");
		 paises= dao.findAll();		
		paises.forEach(s -> log.debug(s));
		
		log.debug("-----------ELIMINAR--------------");
		
		dao.eliminar("ES");
		
		log.info("Buscamos todos los paises");
		 paises= dao.findAll();		
		paises.forEach(s -> log.debug(s));
		

		} catch (DAOException e) {
			log.error(e.getMensaje(), e);
		}

	}

}
