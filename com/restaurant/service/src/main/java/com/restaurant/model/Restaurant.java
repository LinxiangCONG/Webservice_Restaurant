package com.restaurant.model;



public class Restaurant {
	private String name;
	
	private String address;
	
	private double Lat;
	
	private double Lon;
	
	private String category;
	
	public Restaurant() {}

	public Restaurant(String name, double Lon, double Lat, String address, String category) {
		
		this.name = name;
		this.Lon = Lon;
		this.Lat = Lat;
		this.address = address;
		this.category = category;
	}
	
	public Restaurant(String name, String address, String category) {
		this.address = address;
		this.name = name;
		this.category = category;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLat() {
		return Lat;
	}

	public void setLat(double lat) {
		Lat = lat;
	}

	public double getLon() {
		return Lon;
	}

	public void setLon(double lon) {
		Lon = lon;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
