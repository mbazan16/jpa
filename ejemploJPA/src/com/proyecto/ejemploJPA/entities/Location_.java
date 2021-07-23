package com.proyecto.ejemploJPA.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-22T13:34:43.955+0200")
@StaticMetamodel(Location.class)
public class Location_ {
	public static volatile SingularAttribute<Location, Integer> locationId;
	public static volatile SingularAttribute<Location, String> city;
	public static volatile SingularAttribute<Location, String> postalCode;
	public static volatile SingularAttribute<Location, String> stateProvince;
	public static volatile SingularAttribute<Location, String> streetAddress;
	public static volatile ListAttribute<Location, Departmento> departments;
	public static volatile SingularAttribute<Location, Pais> country;
}
