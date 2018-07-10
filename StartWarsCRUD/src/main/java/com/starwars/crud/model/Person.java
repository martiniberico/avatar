package com.starwars.crud.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Person {
	
	@SerializedName("name")
	private String name;
	@SerializedName("height")
	private String height;
	@SerializedName("mass")
	private String mass;
	@SerializedName("hair_color")
	private String hairColor;
	@SerializedName("gender")
	private String gender;
	@SerializedName("planet")
	private String planet;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", mass=" + mass + ", hairColor=" + hairColor
				+ ", gender=" + gender + ", planet=" + planet + "]";
	}
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public Person() {
		this.name = "Martin Iberico";
		this.height = "90";
		this.mass = "100";
		this.hairColor = "black";
		this.gender = "male";
		this.planet = "Alderaan";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlanet() {
		return planet;
	}
	public void setPlanet(String planet) {
		this.planet = planet;
	}

}
