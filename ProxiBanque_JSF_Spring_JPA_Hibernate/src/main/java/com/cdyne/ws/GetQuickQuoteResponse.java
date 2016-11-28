
package com.cdyne.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetQuickQuoteResult" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
    "getQuickQuoteResult"
})
@XmlRootElement(name = "GetQuickQuoteResponse")
public class GetQuickQuoteResponse {

    @XmlElement(name = "GetQuickQuoteResult", required = true)
    protected BigDecimal getQuickQuoteResult;

    /**
     * Obtient la valeur de la propri�t� getQuickQuoteResult.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGetQuickQuoteResult() {
        return getQuickQuoteResult;
    }

    /**
     * D�finit la valeur de la propri�t� getQuickQuoteResult.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGetQuickQuoteResult(BigDecimal value) {
        this.getQuickQuoteResult = value;
    }

}
