package com.bjpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_HISTORY database table.
 * 
 */
@Embeddable
public class JobInstancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EMPLOYEE_ID", insertable=false, updatable=false)
	private long employeeId;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private java.util.Date startDt;

	public JobInstancePK() {
	}
	public long getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public java.util.Date getStartDt() {
		return this.startDt;
	}
	public void setStartDt(java.util.Date startDt) {
		this.startDt = startDt;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobInstancePK)) {
			return false;
		}
		JobInstancePK castOther = (JobInstancePK)other;
		return 
			(this.employeeId == castOther.employeeId)
			&& this.startDt.equals(castOther.startDt);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.employeeId ^ (this.employeeId >>> 32)));
		hash = hash * prime + this.startDt.hashCode();
		
		return hash;
	}
}