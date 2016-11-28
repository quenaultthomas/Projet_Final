
package com.cdyne.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetQuoteDataSetResult" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
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
    "getQuoteDataSetResult"
})
@XmlRootElement(name = "GetQuoteDataSetResponse")
public class GetQuoteDataSetResponse {

    @XmlElement(name = "GetQuoteDataSetResult")
    protected Object getQuoteDataSetResult;

    /**
     * Obtient la valeur de la propriété getQuoteDataSetResult.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGetQuoteDataSetResult() {
        return getQuoteDataSetResult;
    }

    /**
     * Définit la valeur de la propriété getQuoteDataSetResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGetQuoteDataSetResult(Object value) {
        this.getQuoteDataSetResult = value;
    }

}
