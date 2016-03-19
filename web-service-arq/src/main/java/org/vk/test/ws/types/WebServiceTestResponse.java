
package org.vk.test.ws.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="text1Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="text2Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "text1Result",
    "text2Result"
})
@XmlRootElement(name = "webServiceTestResponse")
public class WebServiceTestResponse {

    @XmlElement(required = true)
    protected String text1Result;
    @XmlElement(required = true)
    protected String text2Result;

    /**
     * Gets the value of the text1Result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText1Result() {
        return text1Result;
    }

    /**
     * Sets the value of the text1Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText1Result(String value) {
        this.text1Result = value;
    }

    /**
     * Gets the value of the text2Result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText2Result() {
        return text2Result;
    }

    /**
     * Sets the value of the text2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText2Result(String value) {
        this.text2Result = value;
    }

}
