package com.bjpa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the LOCATIONS database table.
 * 
 */
@Entity
@Table(name="LOCATIONS")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	private long id;

	private String city;

	@Column(name="POSTAL_CODE")
	private String postalCd;

	@Column(name="STATE_PROVINCE")
	private String administration;

	@Column(name="STREET_ADDRESS")
	private String streetAddr;

	@OneToMany(mappedBy = "location")
	private List<Department> departments;
	
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	public Location() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}