package com.proyecto.ejemploJPA.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private Long employeeId;

	@Column(name="commission_pct")
	private BigDecimal commissionPct;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	private Date hireDate;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone_number")
	private String phoneNumber;

	private BigDecimal salary;

	//bi-directional many-to-one association to Departmento
	@OneToMany(mappedBy="employee")
	private List<Departmento> departments;

	//bi-directional many-to-one association to Departmento
	@ManyToOne
	@JoinColumn(name="department_id")
	private Departmento department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Employee employee;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee")
	private List<Employee> employees;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;

	public Employee() {
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<Departmento> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Departmento> departments) {
		this.departments = departments;
	}

	public Departmento addDepartment(Departmento department) {
		getDepartments().add(department);
		department.setEmployee(this);

		return department;
	}

	public Departmento removeDepartment(Departmento department) {
		getDepartments().remove(department);
		department.setEmployee(null);

		return department;
	}

	public Departmento getDepartment() {
		return this.department;
	}

	public void setDepartment(Departmento department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}