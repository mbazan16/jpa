package com.proyecto.ejemploJPA.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-22T13:34:43.960+0200")
@StaticMetamodel(Region.class)
public class Region_ {
	public static volatile SingularAttribute<Region, Integer> regionId;
	public static volatile SingularAttribute<Region, String> regionName;
	public static volatile ListAttribute<Region, Pais> countries;
}
