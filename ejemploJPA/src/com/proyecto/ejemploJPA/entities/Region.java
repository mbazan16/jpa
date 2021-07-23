package com.proyecto.ejemploJPA.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the regions database table.
 * 
 */
@Entity
@Table(name="regions")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="region_id")
	private int regionId;

	@Column(name="region_name")
	private String regionName;

	//bi-directional many-to-one association to Pais
	@OneToMany(mappedBy="region")
	private List<Pais> countries;

	public Region() {
	}

	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<Pais> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Pais> countries) {
		this.countries = countries;
	}

	public Pais addCountry(Pais country) {
		getCountries().add(country);
		country.setRegion(this);

		return country;
	}

	public Pais removeCountry(Pais country) {
		getCountries().remove(country);
		country.setRegion(null);

		return country;
	}

}