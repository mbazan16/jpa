package com.proyecto.ejemploJPA.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-22T13:58:54.756+0200")
@StaticMetamodel(Departmento.class)
public class Departmento_ {
	public static volatile SingularAttribute<Departmento, Long> id;
	public static volatile SingularAttribute<Departmento, String> nombre;
	public static volatile SingularAttribute<Departmento, Employee> employee;
	public static volatile SingularAttribute<Departmento, Location> location;
	public static volatile ListAttribute<Departmento, Employee> employees;
}
