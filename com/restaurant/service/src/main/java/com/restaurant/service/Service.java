package com.restaurant.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.restaurant.model.Category;
import com.restaurant.model.Restaurant;


@WebService(targetNamespace = "http://www.com.restaurant.service")
public class Service {
	
	private double lon;
	private double lat;
	
	public JSONArray getJSONResults(String query) {
		String name = query.replaceAll(" ", "+");
		String url = "https://nominatim.openstreetmap.org/search?q=" + name + "&format=json&limit=1";
		try {
			URL obj = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection)obj.openConnection();
			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
			String inputLine;
			StringBuilder reponse = new StringBuilder();
			while((inputLine = in.readLine()) != null) {
				reponse.append(inputLine);
			}
			in.close();
			return new JSONArray(reponse.toString());
		}catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
		return null;
	}
	
	public void getLonLat(Restaurant restaurant) {		
		JSONArray results = getJSONResults(restaurant.getName());	
		if(results != null) {	// if the api can not find the lat and lon of the restaurant by its name.
			if(results.length() > 0) {
				JSONObject result = results.getJSONObject(0);
				this.lon = Double.parseDouble(result.getString("lon"));
				this.lat = Double.parseDouble(result.getString("lat"));
				System.out.println("Search by name");
				System.out.println("Lon : " + this.lon);
				System.out.println("Lat : " + this.lat);
			}
			else {				// attempt to find the lat and lon by its address
				results = getJSONResults(restaurant.getAddress());
				if(results != null && results.length() > 0) {
					JSONObject result = results.getJSONObject(0);
					this.lon = Double.parseDouble(result.getString("lon"));
					this.lat = Double.parseDouble(result.getString("lat"));
					System.out.println("Search by address");
					System.out.println("Lon : " + this.lon);
					System.out.println("Lat : " + lat);
				}
				else {
					System.out.println("the lat and lon are not found by api");
				}
			}
			
		}
		
 	}
	
	
	@WebMethod
	public String addRestaurant(@WebParam(name="restaurant") Restaurant restaurant) {
		
		this.getLonLat(restaurant);	
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		int res = 0;
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			res = statement.executeUpdate("Insert Into rests(id_r, name_r, lon_r, lat_r, adr_r, id_c) VALUES (DEFAULT,'" + 
								restaurant.getName() + "'," + this.lon + "," + this.lat + ",'" + restaurant.getAddress() + 
								"','" + restaurant.getCategory() + "');");
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PostgresqlJDBC.releaseConnection();
		return (res == 1)? "data was added" : "data added fail";
	}
	
	@WebMethod
	public List<Restaurant> getRestaurantsByCate(@WebParam(name = "cate")Category cate) {
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		ResultSet rs = null;
		List<Restaurant> arrayList = new ArrayList<>();
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			rs = statement.executeQuery("SELECT * FROM rests WHERE id_c = '" + cate.getCateId() + "';");
			
			while(rs != null && rs.next()) {
				arrayList.add(new Restaurant(rs.getString("name_r"),rs.getDouble("lon_r"),rs.getDouble("lat_r"),
												rs.getString("adr_r"), rs.getString("id_c")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();

		if(!arrayList.isEmpty()) {
			return arrayList;
		}
		return null;
	}
	
	@WebMethod
	public Restaurant getRestaurantByName(@WebParam(name = "restName") String restName) {
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		ResultSet rs = null;
		Restaurant restaurant = null;
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			rs = statement.executeQuery("SELECT * FROM rests WHERE name_r = '" + restName + "';");
			if(rs != null && rs.next()) {
				restaurant = new Restaurant(rs.getString("name_r"),rs.getDouble("lon_r"),rs.getDouble("lat_r"),
						rs.getString("adr_r"), rs.getString("id_c"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();

		return restaurant;
	}
	
	@WebMethod
	public Category addCategory(@WebParam(name = "cateName") String cateName) {
		Category category = new Category(cateName);
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		ResultSet rs = null;
		int line = 0;
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			rs = statement.executeQuery("SELECT * FROM cates ORDER BY id_c DESC LIMIT 1;");
			if(rs != null && rs.next()) {
				int maxId = Integer.parseInt(rs.getString("id_c").trim());
				category.setCateId(Integer.toString(maxId+1));
				line = statement.executeUpdate("INSERT INTO cates(id_c, name_c) VALUES ('" + category.getCateId() + "','" + category.getCateName() + "');");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();
		return (line == 1)? category : null;
	}
	
//  function main for testing locally
//	public static void main(String[] args) {
//		Service service = new Service();
//		List<Restaurant> lRestaurants = service.getRestaurantsByCate(new Category("2","Chinese"));
//		for(Restaurant restaurant : lRestaurants) {
//			System.out.println("Name = " + restaurant.getName());
//		}
//		
//		Restaurant restaurant = service.getRestaurantByName("Plancha Grill");
//		System.out.println("The restaurant got by Name = " + restaurant.getName());
//		
//		Restaurant newRestaurant = new Restaurant("Saveurs Gourdmandes", "2 Rue Lavoisier, 95300 Pontoise", "2");
//		System.out.println("Saveurs Gourdmandes : " + service.addRestaurant(newRestaurant));
//		
//		Category category = service.addCategory("English");
//		System.out.println("Category : " + category.getCateName());
//	}

}



/**
 * @class PostgresqlJDBC
 * @brief This class allows developers or users to get and release the resource more easily.
 * 
 * This class contains methods to perform 2 operations : getting DB connection and releasing connection.
 */
class PostgresqlJDBC{
	
	static Connection con;
	
	public static Connection getConnection() {
		
		try {
	         Class.forName("org.postgresql.Driver");
	         con = DriverManager
	            .getConnection("jdbc:postgresql://postgresql-ycc.alwaysdata.net:5432/ycc_blog",
	            "ycc", "QYCQyc123456");
	         System.out.println(con);
	         return con;
	    } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         return null;
	    }
	}
	
	public static void releaseConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
	}
	
}
