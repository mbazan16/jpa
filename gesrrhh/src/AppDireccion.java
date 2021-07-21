import java.util.List;

import com.jpa.dao.DireccionRepository;
import com.jpa.dao.interfaces.IRepositoryDireccion;
import com.jpa.entities.Direccion;
import com.jpa.exceptions.DAOException;

public class AppDireccion {

	public static void main(String[] args) throws DAOException {
		
		System.out.println("Buscar las direcciones por pais");
		IRepositoryDireccion repository = new DireccionRepository();
		
		List<Direccion> direccionesPais = repository.findAllByPais("US");
		
		direccionesPais.forEach(System.out::println);

		Direccion direccionDepartamento  = repository.findOneByDepartamento(10l);
		
		System.out.println("Direccion departamento:"+direccionDepartamento);
				

	}
}
