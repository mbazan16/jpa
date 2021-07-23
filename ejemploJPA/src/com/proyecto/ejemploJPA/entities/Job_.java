package com.proyecto.ejemploJPA.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-22T13:59:31.997+0200")
@StaticMetamodel(Job.class)
public class Job_ {
	public static volatile SingularAttribute<Job, String> jobId;
	public static volatile SingularAttribute<Job, String> jobTitle;
	public static volatile SingularAttribute<Job, BigDecimal> maxSalary;
	public static volatile SingularAttribute<Job, BigDecimal> minSalary;
	public static volatile ListAttribute<Job, Employee> employees;
}
