package com.restaurant.service.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.5
 * 2023-04-05T02:41:22.222+02:00
 * Generated source version: 3.5.5
 *
 */
@WebService(targetNamespace = "http://www.com.restaurant.service", name = "Service")
@XmlSeeAlso({ObjectFactory.class})
public interface Service {

    @WebMethod
    @RequestWrapper(localName = "getJSONResults", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetJSONResults")
    @ResponseWrapper(localName = "getJSONResultsResponse", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetJSONResultsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.restaurant.service.client.JsonArray getJSONResults(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getRestaurantByName", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetRestaurantByName")
    @ResponseWrapper(localName = "getRestaurantByNameResponse", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetRestaurantByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.restaurant.service.client.Restaurant getRestaurantByName(

        @WebParam(name = "restName", targetNamespace = "")
        java.lang.String restName
    );

    @WebMethod
    @RequestWrapper(localName = "addCategory", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.AddCategory")
    @ResponseWrapper(localName = "addCategoryResponse", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.AddCategoryResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.restaurant.service.client.Category addCategory(

        @WebParam(name = "cateName", targetNamespace = "")
        java.lang.String cateName
    );

    @WebMethod
    @RequestWrapper(localName = "getLonLat", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetLonLat")
    @ResponseWrapper(localName = "getLonLatResponse", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetLonLatResponse")
    public void getLonLat(

        @WebParam(name = "arg0", targetNamespace = "")
        com.restaurant.service.client.Restaurant arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getRestaurantsByCate", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetRestaurantsByCate")
    @ResponseWrapper(localName = "getRestaurantsByCateResponse", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.GetRestaurantsByCateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.restaurant.service.client.Restaurant> getRestaurantsByCate(

        @WebParam(name = "cate", targetNamespace = "")
        com.restaurant.service.client.Category cate
    );

    @WebMethod
    @RequestWrapper(localName = "addRestaurant", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.AddRestaurant")
    @ResponseWrapper(localName = "addRestaurantResponse", targetNamespace = "http://www.com.restaurant.service", className = "com.restaurant.service.client.AddRestaurantResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String addRestaurant(

        @WebParam(name = "restaurant", targetNamespace = "")
        com.restaurant.service.client.Restaurant restaurant
    );
}