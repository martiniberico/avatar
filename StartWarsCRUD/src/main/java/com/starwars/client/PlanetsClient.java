package com.starwars.client;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class PlanetsClient {
	
	public String planetsList(String planetListURL) throws IOException{
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url(planetListURL)
		  .get()
		  .addHeader("Cache-Control", "no-cache")
		  .build();

		Response response = client.newCall(request).execute();
		return response.body().string();

	}
	
}
