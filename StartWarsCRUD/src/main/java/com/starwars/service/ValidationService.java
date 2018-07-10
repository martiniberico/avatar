package com.starwars.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.starwars.client.PlanetsClient;
import com.starwars.crud.model.Planet;

public class ValidationService {
	
	private static final String SWAPI_API = "https://swapi.co/api/planets/";
	
	public boolean isValidPlanet(String planetName) {
		String planetListURL = SWAPI_API;
		Gson gson = new Gson();
		List<Planet> planetList = new ArrayList<>();
		PlanetsClient planetsClient = new PlanetsClient();
		try {
			Planet[] planets;
			
			while(planetListURL != null && !planetListURL.isEmpty() && !planetListURL.equals("null")) {
				JSONObject planetListJson = new JSONObject(planetsClient.planetsList(planetListURL));
				planets = gson.fromJson(planetListJson.get("results").toString(), Planet[].class);
				planetList.addAll(Arrays.asList(planets));
				planetListURL = planetListJson.get("next").toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(planetList.size() == 0) return false;
		Planet foundPlanet = planetList.stream().filter(e->e.getName().equals(planetName)).findFirst().orElse(null);
		return foundPlanet == null ? false : true;
		
	}

}
