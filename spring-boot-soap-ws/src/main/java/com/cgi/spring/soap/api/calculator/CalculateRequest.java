//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.05 at 04:32:35 PM EST 
//


package com.cgi.spring.soap.api.calculator;

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
 *         &lt;element name="numOne" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numTwo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "numOne",
    "numTwo",
    "operation"
})
@XmlRootElement(name = "CalculateRequest")
public class CalculateRequest {

    protected int numOne;
    protected int numTwo;
    @XmlElement(required = true)
    protected String operation;

    /**
     * Gets the value of the numOne property.
     * 
     */
    public int getNumOne() {
        return numOne;
    }

    /**
     * Sets the value of the numOne property.
     * 
     */
    public void setNumOne(int value) {
        this.numOne = value;
    }

    /**
     * Gets the value of the numTwo property.
     * 
     */
    public int getNumTwo() {
        return numTwo;
    }

    /**
     * Sets the value of the numTwo property.
     * 
     */
    public void setNumTwo(int value) {
        this.numTwo = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

}