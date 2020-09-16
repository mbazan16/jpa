package daoAnt;

import com.examples.dao.DepartamentoDAO;
import com.examples.model.Departamento;

public class App {

	public static void main(String[] args) {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();

		// Crear un departamento

		Departamento departamento = new Departamento();
		departamento.setId(280l);
		departamento.setName("Mi Departamento");
		departamento.setManagerId(114l);
		departamento.setLocationId(1700l);		
		System.out.println(departamento);

		departamentoDAO.crear(departamento);

		// Modificar un departamento

		departamentoDAO.grabar(departamento.getId(), "Otro departamento", departamento.getManagerId(),
				departamento.getLocationId());

		// Eliminar un departamento
		departamentoDAO.delete(departamento.getId());

	}

}
