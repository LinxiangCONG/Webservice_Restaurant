package rest.management.data;

public class Restaurant {
	
	private String name;
	private String address;
	private String category;
	private double Lon;	// 经度
	private double Lat;	// 纬度
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getLon() {
		return Lon;
	}
	public void setLon(double lon) {
		Lon = lon;
	}
	public double getLat() {
		return Lat;
	}
	public void setLat(double lat) {
		Lat = lat;
	}
	
	
	
}
