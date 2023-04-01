package rest.management.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.html.HTMLEditorKit.Parser;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.json.JSONArray;
import org.json.JSONObject;

import rest.management.data.Restaurant;

public class RestaurantService {
	
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
	
	public void addRestaurant(Restaurant restaurant) {
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			getLonLat(restaurant);
			String sql = "Insert Into Restaurant(id_r, name_r, lon_r, lat_r, adr_r, cate_r) VALUES (DEFAULT,'"
						+restaurant.getName()+ "'," + this.lon + "," + this.lat+ ",'" +restaurant.getAddress() + "','"+ restaurant.getCategory() +"');";
			System.out.println(restaurant.getAddress());
			int res = statement.executeUpdate(sql);
			if(res == 1) {
				System.out.println("data was added");
			}else {
				System.out.println("error : Insert");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();
		
	}
	
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant("MOA BIBIMBAP","38 Rue Vivienne 75002 Paris", "Korean");
		RestaurantService rService = new RestaurantService();
		rService.addRestaurant(restaurant);
	}
	
	

}

class PostgresqlJDBC{
	
	static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
	         Class.forName("org.postgresql.Driver");
	         con = DriverManager
	            .getConnection("jdbc:postgresql://postgresql-ycc.alwaysdata.net:5432/ycc_blog",
	            "ycc", "QYCQyc123456");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con = null;
	}
	
}















