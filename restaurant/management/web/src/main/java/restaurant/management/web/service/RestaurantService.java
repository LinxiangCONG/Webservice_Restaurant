package restaurant.management.web.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.html.HTMLEditorKit.Parser;

import org.apache.el.parser.AstSemicolon;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.json.JSONArray;
import org.json.JSONObject;

import restaurant.management.web.data.Category;
import restaurant.management.web.data.Restaurant;

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
	
	public Restaurant addRestaurant(Restaurant restaurant) {
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			getLonLat(restaurant);
			String sql = "Insert Into rests(id_r, name_r, lon_r, lat_r, adr_r, id_c) VALUES (DEFAULT,'"
						+restaurant.getName()+ "'," + this.lon + "," + this.lat+ ",'" +restaurant.getAddress() + "','"+ restaurant.getCateId() +"');";
			System.out.println(restaurant.getAddress());
			int res = statement.executeUpdate(sql);
			if(res == 1) {
				System.out.println("data was added");
				restaurant.setLon(this.lon);
				restaurant.setLat(this.lat);
				return restaurant;
				
			}else {
				System.out.println("error : Insert");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();
		return null;
	}
	
	public Restaurant searchRestaurantByName(String name) {
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		Restaurant restaurant = null;
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			String query = "SELECT * FROM rests WHERE name_r ='" +  name  + "';";
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				restaurant = new Restaurant(resultSet.getString("name_r"),resultSet.getString("adr_r"),resultSet.getString("id_c"),
						resultSet.getDouble("lon_r"),resultSet.getDouble("lat_r"));
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();
		return restaurant;
	}
	
	public Collection<Restaurant> searchRestaurantsByCate(String cate) {
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		Collection<Restaurant> restaurants = new ArrayList<>();
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			String query = "SELECT * FROM Cates join Rests R on Cates.id_c = R.id_c WHERE name_c = '" + cate + "';";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Restaurant r = new Restaurant(resultSet.getString("name_r"),resultSet.getString("adr_r"),resultSet.getString("id_c"),
						resultSet.getDouble("lon_r"),resultSet.getDouble("lat_r"));
				restaurants.add(r);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();
		return restaurants;
	}
	
	public Category addCategory(Category category) {
		PostgresqlJDBC.con = PostgresqlJDBC.getConnection();
		try {
			Statement statement = PostgresqlJDBC.con.createStatement();
			String sql = "Insert Into cates(id_c, name_c) VALUES ('"+  category.getId() +"','"
						+category.getName()+ "');";
			int res = statement.executeUpdate(sql);
			if(res == 1) {
				System.out.println("data was added");
				return category;
				
			}
			else {
				System.out.println("error : Insert");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PostgresqlJDBC.releaseConnection();
		return null;
	}
	
	
	
//	public static void main(String[] args) {
//		Restaurant restaurant = new Restaurant("MOA BIBIMBAP","38 Rue Vivienne 75002 Paris", "Korean");
//		Restaurant restaurant = new Restaurant("le petit raspail","17 Rue Raspail, 92300 Levallois-Perret","French");
//		String cate = "Italian";
//		RestaurantService rService = new RestaurantService();
//		Category category = new Category("01","French");
//		rService.addCategory(category);
//		Restaurant restaurant2 = rService.addRestaurant(restaurant);
//		restaurant2.infos();
//		Collection<Restaurant> restaurants = rService.searchRestaurantsByCate(cate);
//		for(Restaurant restaurant : restaurants) {
//			restaurant.infos();
//		}
//	}
	
	

}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con = null;
	}
	
}















