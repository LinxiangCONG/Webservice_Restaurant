
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

@XmlRootElement(name = "getLonLat", namespace = "http://www.com.restaurant.service")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLonLat", namespace = "http://www.com.restaurant.service")

public class GetLonLat {

    @XmlElement(name = "arg0")
    private com.restaurant.model.Restaurant arg0;

    public com.restaurant.model.Restaurant getArg0() {
        return this.arg0;
    }

    public void setArg0(com.restaurant.model.Restaurant newArg0)  {
        this.arg0 = newArg0;
    }

}

