package com.bjpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name = "EMPLOYEES")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMPLOYEE_ID")
	private long id;

	@Column(name = "COMMISSION_PCT")
	private Double commissionPct;

	private String email;

	@Column(name = "FIRST_NAME")
	private String firstNm;

	@Temporal(TemporalType.DATE)
	@Column(name = "HIRE_DATE")
	private Date hireDt;

	@Column(name = "LAST_NAME")
	private String lastNm;

	@Column(name = "PHONE_NUMBER")
	private String phoneNbr;

	private Float salary;

	@OneToMany(mappedBy = "manager")
	private List<Employee> subordinates;

	@OneToMany(mappedBy = "deptManager")
	private List<Department> managedDepts;

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "JOB_ID")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;

	public Employee() {
	}

	public long getId() {
		return this.id;
	}

	public Double getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstNm() {
		return this.firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public Date getHireDt() {
		return this.hireDt;
	}

	public void setHireDt(Date hireDt) {
		this.hireDt = hireDt;
	}

	public String getLastNm() {
		return this.lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public String getPhoneNbr() {
		return this.phoneNbr;
	}

	public void setPhoneNbr(String phoneNbr) {
		this.phoneNbr = phoneNbr;
	}

	public Float getSalary() {
		return this.salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public Employee addSubordinate(Employee subordinate) {
		getSubordinates().add(subordinate);
		subordinate.setManager(this);

		return subordinate;
	}

	public Employee removeSubordinate(Employee subordinate) {
		getSubordinates().remove(subordinate);
		subordinate.setManager(null);

		return subordinate;
	}

	public List<Department> getManagedDepts() {
		return managedDepts;
	}

	public void setManagedDepts(List<Department> managedDepts) {
		this.managedDepts = managedDepts;
	}

	public Department addManagedDept(Department managedDept) {
		getManagedDepts().add(managedDept);
		managedDept.setManager(this);

		return managedDept;
	}

	public Department removeManagedDept(Department managedDept) {
		getManagedDepts().remove(managedDept);
		managedDept.setManager(null);

		return managedDept;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", commissionPct=" + commissionPct + ", email=" + email + ", firstNm=" + firstNm
				+ ", hireDt=" + hireDt + ", lastNm=" + lastNm + ", manager=" + manager.getFirstNm() + " "
				+ manager.getLastNm() + ", phoneNbr=" + phoneNbr + ", salary=" + salary + ", department="
				+ department.getName() + ", job=" + job.getJobTtl() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstNm == null) ? 0 : firstNm.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastNm == null) ? 0 : lastNm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstNm == null) {
			if (other.firstNm != null)
				return false;
		} else if (!firstNm.equals(other.firstNm))
			return false;
		if (id != other.id)
			return false;
		if (lastNm == null) {
			if (other.lastNm != null)
				return false;
		} else if (!lastNm.equals(other.lastNm))
			return false;
		return true;
	}

}