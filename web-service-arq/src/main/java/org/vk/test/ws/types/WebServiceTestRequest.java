
package org.vk.test.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="text1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="text2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "text1",
    "text2"
})
@XmlRootElement(name = "webServiceTestRequest")
public class WebServiceTestRequest {

    protected String text1;
    protected String text2;

    /**
     * Gets the value of the text1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText1() {
        return text1;
    }

    /**
     * Sets the value of the text1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText1(String value) {
        this.text1 = value;
    }

    /**
     * Gets the value of the text2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText2() {
        return text2;
    }

    /**
     * Sets the value of the text2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText2(String value) {
        this.text2 = value;
    }

}
