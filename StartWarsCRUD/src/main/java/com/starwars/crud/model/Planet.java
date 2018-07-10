package com.starwars.crud.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Planet {
	
	@SerializedName("name")
	private String name;
	@SerializedName("rotation_period")
	private String rotationPeriod;
	@SerializedName("orbital_period")
	private String orbitalPeriod;
	@SerializedName("diameter")
	private String diameter;
	@SerializedName("climate")
	private String climate;
	@SerializedName("gravity")
	private String gravity;
	@SerializedName("terrain")
	private String terrain;
	@SerializedName("surface_water")
	private String surfaceWater;
	@SerializedName("population")
	private String population;
	
	private List<String> residentsURL;
	private List<String> filmsURL;
	
	@SerializedName("created")
	private String created;
	@SerializedName("edited")
	private String edited;
	@SerializedName("url")
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRotationPeriod() {
		return rotationPeriod;
	}
	public void setRotationPeriod(String rotationPeriod) {
		this.rotationPeriod = rotationPeriod;
	}
	public String getOrbitalPeriod() {
		return orbitalPeriod;
	}
	public void setOrbitalPeriod(String orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getGravity() {
		return gravity;
	}
	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getSurfaceWater() {
		return surfaceWater;
	}
	public void setSurfaceWater(String surfaceWater) {
		this.surfaceWater = surfaceWater;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public List<String> getResidentsURL() {
		return residentsURL;
	}
	public void setResidentsURL(List<String> residentsURL) {
		this.residentsURL = residentsURL;
	}
	public List<String> getFilmsURL() {
		return filmsURL;
	}
	public void setFilmsURL(List<String> filmsURL) {
		this.filmsURL = filmsURL;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getEdited() {
		return edited;
	}
	public void setEdited(String edited) {
		this.edited = edited;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
