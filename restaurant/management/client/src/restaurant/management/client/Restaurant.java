package restaurant.management.client;

public class Restaurant {
	private String name;
	private String address;
	private double lon;
	private double lat;
	private String cateId;
	
	public Restaurant() {}

	public Restaurant(String name, String address, String cateId) {
		this.name = name;
		this.address = address;
		this.cateId = cateId;
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
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	
	
}
