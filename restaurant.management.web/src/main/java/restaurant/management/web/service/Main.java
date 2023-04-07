package restaurant.management.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import restaurant.management.web.data.Category;
import restaurant.management.web.data.Restaurant;
import restaurant.management.web.resource.RestaurantResource;


public class Main {
	public static void main(String[] args) {

		 
		 Restaurant r1 = new Restaurant();
//		 r1.setId();
		 r1.setName("Plancha Grill");
		 r1.setAdresse("Rue");
		 r1.setCateId("2");
//		 r1.setLatitude("1.1");
//		 r1.setLongitude("1.1");
		 
		 RestaurantService rs = new RestaurantService();
		 
//		 System.out.println(rs.getRestaurant_BD(1));
//		 System.out.println(rs.getAllRestaurants());
		 
		 
//		 System.out.println(rs.getRestaurant_BD_Id("1"));
//		 System.out.println(rs.getRestaurant_BD_Name("Plancha Grill"));	 
//		 System.out.println(rs.addRestaurant(r1));		 
//		 System.out.println(rs.updateRestaurant("1",r1));
		 
//		 System.out.println(rs.searchRestaurantsByCate("Chinese"));
		
//		 Category c = new Category("7","xxx");
//		 System.out.println(rs.addCategory(c));
		 
//		 rs.getAllRestaurants();
		 
		 
//		 rs.getRestaurant_BD_Name("plancha+grill");
//		 rs.getRestaurant_BD(1);
//		RestaurantResource rr = new RestaurantResource();
//		 System.out.println(rr.getRestaurant_BD_Name("plancha+grill"));
//		 System.out.println(rr.getRestaurant("plancha_grill"));
//		System.out.println(rr.getRestaurant(1));
//		 rr.getRestaurant_BD(2);
//		 Restaurant r = Main.getName("plancha+grill");
//		 Restaurant r = Main.add(r1);

		 
		 
	}
	
	

//	public static Restaurant add(Restaurant r) {
//		
//		Connection connection = PostgresqlJDBC.getConnection();
//		try {
//			Statement statement = connection.createStatement();
//			String query = "INSERT INTO restaurant(id_r, name_r, lon_r, lat_r, adr_r, cate_r) VALUES("
//							+ r.getId() +",'"+ r.getName() + "','"+ r.getLongitude() + "','" + r.getLatitude() + "','"
//							+ r.getAdresse() + "','" + r.getCategorie() + "');";
//			int res = statement.executeUpdate(query);
//			if(res == 1) {
//				System.out.println("data was added");
//			}else {
//				System.out.println("error : executeUpdate");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PostgresqlJDBC.releaseConnection();
//		return r;
//	}
	
//	public static Restaurant getName(String name) {
//		Restaurant r = null;
//		Connection connection = PostgresqlJDBC.getConnection();
//		try {
//			Statement statement = connection.createStatement();
//			String query = "select * from restaurant where name_r = " + "'"+name+"'";
//			ResultSet rs = statement.executeQuery(query);
//			if(rs.next()) {
//				Integer id_r = rs.getInt("id_r");
//				String name_r = rs.getString("name_r");
//				String lon_r = rs.getString("lon_r");
//				String lat_r = rs.getString("lat_r");
//				String adr_r = rs.getString("adr_r");
//				String cate_r = rs.getString("cate_r");
//				System.out.printf("id = %s, name = %s, adr = %s, lon = %s, lat = %s, cate = %s",id_r, name_r ,adr_r ,lon_r ,lat_r ,cate_r);
//				r = new Restaurant(id_r, name_r, adr_r, lon_r, lat_r, cate_r);
//			}
//		} 
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PostgresqlJDBC.releaseConnection();
//		return r;
//	}
	
	
	
	
	
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
}
