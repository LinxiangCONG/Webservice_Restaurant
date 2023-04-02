package restaurant.management.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import restaurant.management.web.data.Restaurant;

public class RestClient {
	private static final String REST_URI
		= "http://localhost:8080/restaurant.management.web/api";
	
	private Client client = ClientBuilder.newClient();
	
	public Restaurant getRestaurantByName(String name) {
		return client
				.target(REST_URI)
				.path("retaurants/"+name)
				.request(MediaType.APPLICATION_XML)
				.get(Restaurant.class);	
	}
	
	public List<Restaurant> getRestaurantsByCate(String cate) {
		return client
				.target(REST_URI)
				.path("restaurants/category/"+cate)
				.request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Restaurant>>() {});	
	}
	
	public Response createXMLRestaurant(Restaurant restaurant) {
		return client.target(REST_URI)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.entity(restaurant, MediaType.APPLICATION_XML));
	}
}
