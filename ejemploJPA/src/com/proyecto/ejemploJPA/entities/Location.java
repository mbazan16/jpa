
package com.proyecto.ejemploJPA.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="location_id")
	private int locationId;

	private String city;

	@Column(name="postal_code")
	private String postalCode;

	@Column(name="state_province")
	private String stateProvince;

	@Column(name="street_address")
	private String streetAddress;

	//bi-directional many-to-one association to Departmento
	@OneToMany(mappedBy="location")
	private List<Departmento> departments;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="country_id")
	private Pais country;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public List<Departmento> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Departmento> departments) {
		this.departments = departments;
	}

	public Departmento addDepartment(Departmento department) {
		getDepartments().add(department);
		department.setLocation(this);

		return department;
	}

	public Departmento removeDepartment(Departmento department) {
		getDepartments().remove(department);
		department.setLocation(null);

		return department;
	}

	public Pais getCountry() {
		return this.country;
	}

	public void setCountry(Pais country) {
		this.country = country;
	}

}