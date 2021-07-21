import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.entities.Empleado;
import com.jpa.entities.Trabajo;

public class AppTrabajo {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HR");
		EntityManager em = emf.createEntityManager();
		
		Trabajo trabajo = em.find(Trabajo.class, "IT_PROG");
		
		System.out.println("Trabajo id:"+trabajo.getId());
		System.out.println("Titulo."+trabajo.getTitulos());
		
		List<Empleado> empleados = trabajo.getEmpleados();
		System.out.println("Lista de empleados"+ empleados);
		empleados.forEach(System.out::println);
		
		/*
		 * Empleado empleado = em.find(Empleado.class, 104l);
		 * 
		 * System.out.println(empleado);
		 * 
		 * System.out.println("Trabajo Empleado id:"+empleado.getTrabajo().getId());
		 * System.out.println("Titulo Trabajo Empleado."+empleado.getTrabajo().
		 * getTitulos());
		 * 
		 */
		
		
	}

}
