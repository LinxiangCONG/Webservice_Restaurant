
package com.restaurant.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.restaurant.service.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCategory_QNAME = new QName("http://www.com.restaurant.service", "addCategory");
    private final static QName _AddCategoryResponse_QNAME = new QName("http://www.com.restaurant.service", "addCategoryResponse");
    private final static QName _AddRestaurant_QNAME = new QName("http://www.com.restaurant.service", "addRestaurant");
    private final static QName _AddRestaurantResponse_QNAME = new QName("http://www.com.restaurant.service", "addRestaurantResponse");
    private final static QName _GetJSONResults_QNAME = new QName("http://www.com.restaurant.service", "getJSONResults");
    private final static QName _GetJSONResultsResponse_QNAME = new QName("http://www.com.restaurant.service", "getJSONResultsResponse");
    private final static QName _GetLonLat_QNAME = new QName("http://www.com.restaurant.service", "getLonLat");
    private final static QName _GetLonLatResponse_QNAME = new QName("http://www.com.restaurant.service", "getLonLatResponse");
    private final static QName _GetRestaurantByName_QNAME = new QName("http://www.com.restaurant.service", "getRestaurantByName");
    private final static QName _GetRestaurantByNameResponse_QNAME = new QName("http://www.com.restaurant.service", "getRestaurantByNameResponse");
    private final static QName _GetRestaurantsByCate_QNAME = new QName("http://www.com.restaurant.service", "getRestaurantsByCate");
    private final static QName _GetRestaurantsByCateResponse_QNAME = new QName("http://www.com.restaurant.service", "getRestaurantsByCateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.restaurant.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCategory }
     * 
     */
    public AddCategory createAddCategory() {
        return new AddCategory();
    }

    /**
     * Create an instance of {@link AddCategoryResponse }
     * 
     */
    public AddCategoryResponse createAddCategoryResponse() {
        return new AddCategoryResponse();
    }

    /**
     * Create an instance of {@link AddRestaurant }
     * 
     */
    public AddRestaurant createAddRestaurant() {
        return new AddRestaurant();
    }

    /**
     * Create an instance of {@link AddRestaurantResponse }
     * 
     */
    public AddRestaurantResponse createAddRestaurantResponse() {
        return new AddRestaurantResponse();
    }

    /**
     * Create an instance of {@link GetJSONResults }
     * 
     */
    public GetJSONResults createGetJSONResults() {
        return new GetJSONResults();
    }

    /**
     * Create an instance of {@link GetJSONResultsResponse }
     * 
     */
    public GetJSONResultsResponse createGetJSONResultsResponse() {
        return new GetJSONResultsResponse();
    }

    /**
     * Create an instance of {@link GetLonLat }
     * 
     */
    public GetLonLat createGetLonLat() {
        return new GetLonLat();
    }

    /**
     * Create an instance of {@link GetLonLatResponse }
     * 
     */
    public GetLonLatResponse createGetLonLatResponse() {
        return new GetLonLatResponse();
    }

    /**
     * Create an instance of {@link GetRestaurantByName }
     * 
     */
    public GetRestaurantByName createGetRestaurantByName() {
        return new GetRestaurantByName();
    }

    /**
     * Create an instance of {@link GetRestaurantByNameResponse }
     * 
     */
    public GetRestaurantByNameResponse createGetRestaurantByNameResponse() {
        return new GetRestaurantByNameResponse();
    }

    /**
     * Create an instance of {@link GetRestaurantsByCate }
     * 
     */
    public GetRestaurantsByCate createGetRestaurantsByCate() {
        return new GetRestaurantsByCate();
    }

    /**
     * Create an instance of {@link GetRestaurantsByCateResponse }
     * 
     */
    public GetRestaurantsByCateResponse createGetRestaurantsByCateResponse() {
        return new GetRestaurantsByCateResponse();
    }

    /**
     * Create an instance of {@link JsonArray }
     * 
     */
    public JsonArray createJsonArray() {
        return new JsonArray();
    }

    /**
     * Create an instance of {@link Restaurant }
     * 
     */
    public Restaurant createRestaurant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCategory }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "addCategory")
    public JAXBElement<AddCategory> createAddCategory(AddCategory value) {
        return new JAXBElement<AddCategory>(_AddCategory_QNAME, AddCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategoryResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCategoryResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "addCategoryResponse")
    public JAXBElement<AddCategoryResponse> createAddCategoryResponse(AddCategoryResponse value) {
        return new JAXBElement<AddCategoryResponse>(_AddCategoryResponse_QNAME, AddCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRestaurant }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddRestaurant }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "addRestaurant")
    public JAXBElement<AddRestaurant> createAddRestaurant(AddRestaurant value) {
        return new JAXBElement<AddRestaurant>(_AddRestaurant_QNAME, AddRestaurant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRestaurantResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddRestaurantResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "addRestaurantResponse")
    public JAXBElement<AddRestaurantResponse> createAddRestaurantResponse(AddRestaurantResponse value) {
        return new JAXBElement<AddRestaurantResponse>(_AddRestaurantResponse_QNAME, AddRestaurantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJSONResults }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetJSONResults }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getJSONResults")
    public JAXBElement<GetJSONResults> createGetJSONResults(GetJSONResults value) {
        return new JAXBElement<GetJSONResults>(_GetJSONResults_QNAME, GetJSONResults.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJSONResultsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetJSONResultsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getJSONResultsResponse")
    public JAXBElement<GetJSONResultsResponse> createGetJSONResultsResponse(GetJSONResultsResponse value) {
        return new JAXBElement<GetJSONResultsResponse>(_GetJSONResultsResponse_QNAME, GetJSONResultsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLonLat }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetLonLat }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getLonLat")
    public JAXBElement<GetLonLat> createGetLonLat(GetLonLat value) {
        return new JAXBElement<GetLonLat>(_GetLonLat_QNAME, GetLonLat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLonLatResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetLonLatResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getLonLatResponse")
    public JAXBElement<GetLonLatResponse> createGetLonLatResponse(GetLonLatResponse value) {
        return new JAXBElement<GetLonLatResponse>(_GetLonLatResponse_QNAME, GetLonLatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRestaurantByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getRestaurantByName")
    public JAXBElement<GetRestaurantByName> createGetRestaurantByName(GetRestaurantByName value) {
        return new JAXBElement<GetRestaurantByName>(_GetRestaurantByName_QNAME, GetRestaurantByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRestaurantByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getRestaurantByNameResponse")
    public JAXBElement<GetRestaurantByNameResponse> createGetRestaurantByNameResponse(GetRestaurantByNameResponse value) {
        return new JAXBElement<GetRestaurantByNameResponse>(_GetRestaurantByNameResponse_QNAME, GetRestaurantByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantsByCate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRestaurantsByCate }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getRestaurantsByCate")
    public JAXBElement<GetRestaurantsByCate> createGetRestaurantsByCate(GetRestaurantsByCate value) {
        return new JAXBElement<GetRestaurantsByCate>(_GetRestaurantsByCate_QNAME, GetRestaurantsByCate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantsByCateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRestaurantsByCateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.com.restaurant.service", name = "getRestaurantsByCateResponse")
    public JAXBElement<GetRestaurantsByCateResponse> createGetRestaurantsByCateResponse(GetRestaurantsByCateResponse value) {
        return new JAXBElement<GetRestaurantsByCateResponse>(_GetRestaurantsByCateResponse_QNAME, GetRestaurantsByCateResponse.class, null, value);
    }

}
