package com.bjpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JOB_HISTORY database table.
 * 
 */
@Entity
@Table(name="JOB_HISTORY")
@NamedQuery(name="JobInstance.findAll", query="SELECT j FROM JobInstance j")
public class JobInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobInstancePK id;

	@Column(name="DEPARTMENT_ID")
	private java.math.BigDecimal departmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDt;

	@Column(name="JOB_ID")
	private String jobId;

	public JobInstance() {
	}

	public JobInstancePK getId() {
		return this.id;
	}

	public void setId(JobInstancePK id) {
		this.id = id;
	}

	public java.math.BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(java.math.BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	public Date getEndDt() {
		return this.endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}