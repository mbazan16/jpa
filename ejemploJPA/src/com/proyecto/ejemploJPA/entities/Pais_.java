package com.proyecto.ejemploJPA.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-22T13:34:44.219+0200")
@StaticMetamodel(Pais.class)
public class Pais_ {
	public static volatile SingularAttribute<Pais, String> id;
	public static volatile SingularAttribute<Pais, String> nombre;
	public static volatile SingularAttribute<Pais, Region> region;
	public static volatile ListAttribute<Pais, Location> locations;
}
