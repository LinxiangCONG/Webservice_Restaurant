
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

@XmlRootElement(name = "getJSONResults", namespace = "http://www.com.restaurant.service")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getJSONResults", namespace = "http://www.com.restaurant.service")

public class GetJSONResults {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

