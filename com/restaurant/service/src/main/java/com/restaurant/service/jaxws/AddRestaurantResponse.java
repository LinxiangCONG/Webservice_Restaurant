
package com.restaurant.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.5
 * Tue Apr 04 04:15:44 CEST 2023
 * Generated source version: 3.5.5
 */

@XmlRootElement(name = "addRestaurantResponse", namespace = "http://www.com.restaurant.service")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addRestaurantResponse", namespace = "http://www.com.restaurant.service")

public class AddRestaurantResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}

