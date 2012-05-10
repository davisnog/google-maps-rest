package com.davisnog.geocode;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Geocode {

	private final String address;
	private HttpURLConnection connection;

	public Geocode(String address) {
		this.address = address;
	}
	
	public Geocode(String address, HttpURLConnection connection) {
		this.address = address;
		this.connection = connection;
	}
	
	public ResultList result(){
		final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		
		Reader reader = null;
		
		try{
			reader = getReaderData();
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return gson.fromJson(reader, ResultList.class);
	}
	
	private final Reader getReaderData() throws IOException{
		if(connection == null){
			final String encodeAddress = URLEncoder.encode(this.address, "UTF-8");
			
			final String requestURL = "http://maps.googleapis.com/maps/api/geocode/json?address=" + encodeAddress + "&sensor=false";
			final URL url = new URL(requestURL);

			this.connection = (HttpURLConnection)url.openConnection();
		}
		
		return new InputStreamReader(connection.getInputStream());
	}
	
}
