package com.proyecto.ejemploJPA.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-07-22T13:59:59.745+0200")
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Long> employeeId;
	public static volatile SingularAttribute<Employee, BigDecimal> commissionPct;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, String> firstName;
	public static volatile SingularAttribute<Employee, Date> hireDate;
	public static volatile SingularAttribute<Employee, String> lastName;
	public static volatile SingularAttribute<Employee, String> phoneNumber;
	public static volatile SingularAttribute<Employee, BigDecimal> salary;
	public static volatile ListAttribute<Employee, Departmento> departments;
	public static volatile SingularAttribute<Employee, Departmento> department;
	public static volatile SingularAttribute<Employee, Employee> employee;
	public static volatile ListAttribute<Employee, Employee> employees;
	public static volatile SingularAttribute<Employee, Job> job;
}
