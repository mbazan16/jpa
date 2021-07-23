package com.proyecto.ejemploJPA.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-22T13:53:32.750+0200")
@StaticMetamodel(JobHistory.class)
public class JobHistory_ {
	public static volatile SingularAttribute<JobHistory, Date> endDate;
	public static volatile SingularAttribute<JobHistory, Date> startDate;
	public static volatile SingularAttribute<JobHistory, Long> departmentId;
	public static volatile SingularAttribute<JobHistory, Long> employeeId;
	public static volatile SingularAttribute<JobHistory, Long> jobId;
}
