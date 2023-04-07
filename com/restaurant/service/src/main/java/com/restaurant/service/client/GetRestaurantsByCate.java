
package com.restaurant.service.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getRestaurantsByCate complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getRestaurantsByCate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cate" type="{http://www.com.restaurant.service}category" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRestaurantsByCate", propOrder = {
    "cate"
})
public class GetRestaurantsByCate {

    protected Category cate;

    /**
     * 获取cate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCate() {
        return cate;
    }

    /**
     * 设置cate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCate(Category value) {
        this.cate = value;
    }

}
