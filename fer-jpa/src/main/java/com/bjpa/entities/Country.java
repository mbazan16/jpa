package com.bjpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the COUNTRIES database table.
 * 
 */
@Entity
@Table(name = "COUNTRIES")
@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COUNTRY_ID")
	private String id;

	@Column(name = "COUNTRY_NAME")
	private String countryNm;

	// bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name = "REGION_ID")
	private Region region;

	// bi-directional many-to-one association to Location
	@OneToMany(mappedBy = "country")
	private List<Location> locations;

	public Country() {
	}

	public String getId() {
		return this.id;
	}

	public String getCountryNm() {
		return this.countryNm;
	}

	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCountry(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCountry(null);

		return location;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryNm=" + countryNm + ", region=" + region.getRegionNm() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryNm == null) ? 0 : countryNm.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Country other = (Country) obj;
		if (countryNm == null) {
			if (other.countryNm != null)
				return false;
		} else if (!countryNm.equals(other.countryNm))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}