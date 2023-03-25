package rest.management.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class RestaurantService {
	
	Connection con = null;
	
	public RestaurantService() {
		con = PostgresqlJDBC.getConnection();
		System.out.println(con);
	}
	
	public static void main(String[] args) {
		RestaurantService rs = new RestaurantService();
	}
	

}

class PostgresqlJDBC{
	
	public static Connection getConnection() {
		Connection c = null;
		try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://postgresql-ycc.alwaysdata.net:5432/ycc_blog",
	            "ycc", "QYCQyc123456");
	         return c;
	    } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	         return null;
	    }
		
		
	}
	
	
}
