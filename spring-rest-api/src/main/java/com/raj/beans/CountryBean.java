package com.raj.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class CountryBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="Code")
	private String code;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Continent")
	private String continent;
	
	@Column(name="Region")
	private String region;
	
	@Column(name="SurfaceArea")
	private String surfaceArea;
	
	@Column(name="IndepYear")
	private String indepYear;
	
	@Column(name="Population")
	private String population;
	
	@Column(name="LifeExpentancy")
	private String lifeExpectancy;
	
	@Column(name="GNP")
	private String gnp;
	
	@Column(name="GNPOld")
	private String gnpOld;
	
	@Column(name="LocalName")
	private String localName;
	
	@Column(name="GovernmentForm")
	private String governmentForm;
	
	@Column(name="HeadOfState")
	private String headOfState;
	
	@Column(name="Capital")
	private String capital;
	
	@Column(name="Code2")
	private String code2;

	public CountryBean() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(String surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(String indepYear) {
		this.indepYear = indepYear;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(String lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getGnp() {
		return gnp;
	}

	public void setGnp(String gnp) {
		this.gnp = gnp;
	}

	public String getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(String gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
}
