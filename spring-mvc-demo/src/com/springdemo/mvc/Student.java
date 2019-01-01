package com.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favLanguage;
	private String[] favOS;
	
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		
		countryOptions.put("CHN", "China");
		countryOptions.put("JPN", "Japan");
		countryOptions.put("KOR", "Korea");
		countryOptions.put("RUS", "Russia");
		countryOptions.put("USA", "USA");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavLanguage() {
		return favLanguage;
	}

	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}

	public String[] getFavOS() {
		return favOS;
	}

	public void setFavOS(String[] favOS) {
		this.favOS = favOS;
	}
	
	

}
