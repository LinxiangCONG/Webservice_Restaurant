package restaurant.management.web.resource;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import restaurant.management.web.data.Category;
import restaurant.management.web.data.Restaurant;
import restaurant.management.web.service.RestaurantService;

@Path("/")
public class RestaurantResource {
	
	RestaurantService service = new RestaurantService();
	
	@Context
	UriInfo uriInfo;
	
	@POST
	@Path("/restaurants")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addRestaurant(Restaurant restaurant) {
		Restaurant r = service.addRestaurant(restaurant);
		if(r == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath();
		return Response.status(Response.Status.CREATED)
						.entity(r)
						.contentLocation(uri.resolve(newUri))
						.build();
	}
	
	@GET
	@Path("/restaurants/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getRestaurantByName(@PathParam("name") String name) {
		name = name.replaceAll("_", " ");
		Restaurant restaurant = service.searchRestaurantByName(name);	
		if(restaurant == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		restaurant.infos();
		Link link = Link.fromUri(uriInfo.getRequestUri())
					.rel("self")
					.type("application/xml")
					.build();
		return Response.status(Response.Status.OK)
						.entity(restaurant)
						.links(link)
						.build();
	}
	
	@GET
	@Path("/restaurants/category/{cate}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getRestaurantsByCate(@PathParam("cate") String cate) {
		Collection<Restaurant> restaurants = service.searchRestaurantsByCate(cate);	
		if(restaurants.isEmpty()) {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		
		Restaurant[] restaurants2 = restaurants.toArray(new Restaurant[restaurants.size()]);
		Link link = Link.fromUri(uriInfo.getRequestUri())
					.rel("self")
					.type("application/xml")
					.build();
		return Response.status(Response.Status.OK)
						.entity(restaurants2)
						.links(link)
						.build();
	}
	
	@POST
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addRestaurant(Category category) {
		Category c = service.addCategory(category);
		if(c == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath();
		return Response.status(Response.Status.CREATED)
						.entity(c)
						.contentLocation(uri.resolve(newUri))
						.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
