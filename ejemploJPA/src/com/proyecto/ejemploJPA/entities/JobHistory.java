package com.proyecto.ejemploJPA.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the job_history database table.
 * 
 */
@Entity
@Table(name="job_history")
@NamedQuery(name="JobHistory.findAll", query="SELECT j FROM JobHistory j")
@IdClass(JobHistoryPK.class)
public class JobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="department_id")
	private Long departmentId;

	@Id
	@Column(name="employee_id")
	private Long employeeId;

	@Id
	@Column(name="job_id")
	private Long jobId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	public JobHistory() {
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}