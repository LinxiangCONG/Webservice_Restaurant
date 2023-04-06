package restaurant.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
public class Restaurant {
	
	private String name;
	private String address;
	private String cateId;
	private double Lon;	
	private double Lat;	
	
	public Restaurant() {}
	
	public Restaurant(String name, String address, String cateId) {
		this.name = name;
		this.address = address;
		this.cateId = cateId;
	}
	
	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public Restaurant(String name, String address, String cateId, double lon, double lat) {
		this.name = name;
		this.address = address;
		this.cateId = cateId;
		this.Lon = lon;
		this.Lat = lat;
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
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
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
	
	public void infos() {
		System.out.printf("(Name : %s, Address : %s, Lon : %f, Lat : %f, category : %s);\n",getName(),getAddress(),getLon(),getLat(),getCateId());
	}
}
