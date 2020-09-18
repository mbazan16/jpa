package com.bjpa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name = "LOCATIONS")
@NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOCATION_ID")
	private long id;

	private String city;

	@Column(name = "POSTAL_CODE")
	private String postalCd;

	@Column(name = "STATE_PROVINCE")
	private String administration;

	@Column(name = "STREET_ADDRESS")
	private String streetAddr;

	@OneToMany(mappedBy = "location")
	private List<Department> departments;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	public Location() {
	}

	public long getId() {
		return this.id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCd() {
		return this.postalCd;
	}

	public void setPostalCd(String postalCd) {
		this.postalCd = postalCd;
	}

	public String getAdministration() {
		return this.administration;
	}

	public void setAdministration(String administration) {
		this.administration = administration;
	}

	public String getStreetAddr() {
		return this.streetAddr;
	}

	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Department addDepartment(Department department) {
		getDepartments().add(department);
		department.setLocation(this);

		return department;
	}

	public Department removeDepartment(Department department) {
		getDepartments().remove(department);
		department.setLocation(null);

		return department;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", postalCd=" + postalCd + ", administration=" + administration
				+ ", streetAddr=" + streetAddr + ", country=" + country.getCountryNm() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((streetAddr == null) ? 0 : streetAddr.hashCode());
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
		Location other = (Location) obj;
		if (id != other.id)
			return false;
		if (streetAddr == null) {
			if (other.streetAddr != null)
				return false;
		} else if (!streetAddr.equals(other.streetAddr))
			return false;
		return true;
	}

}