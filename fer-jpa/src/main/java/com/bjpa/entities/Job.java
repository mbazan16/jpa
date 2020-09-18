package com.bjpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the JOBS database table.
 * 
 */
@Entity
@Table(name="JOBS")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JOB_ID")
	private String id;

	@Column(name="JOB_TITLE")
	private String jobTtl;

	@Column(name="MAX_SALARY")
	private BigDecimal maxSalary;

	@Column(name="MIN_SALARY")
	private BigDecimal minSalary;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="job")
	private List<Employee> employees;

	public Job() {
	}

	public String getId() {
		return this.id;
	}

	public String getJobTtl() {
		return this.jobTtl;
	}

	public void setJobTtl(String jobTtl) {
		this.jobTtl = jobTtl;
	}

	public BigDecimal getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	public BigDecimal getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJob(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJob(null);

		return employee;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobTtl=" + jobTtl + ", maxSalary=" + maxSalary + ", minSalary=" + minSalary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jobTtl == null) ? 0 : jobTtl.hashCode());
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
		Job other = (Job) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jobTtl == null) {
			if (other.jobTtl != null)
				return false;
		} else if (!jobTtl.equals(other.jobTtl))
			return false;
		return true;
	}

}