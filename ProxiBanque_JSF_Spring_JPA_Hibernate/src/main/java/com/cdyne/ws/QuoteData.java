
package com.cdyne.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour QuoteData complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="QuoteData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StockSymbol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastTradeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LastTradeDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="StockChange" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OpenAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DayHigh" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DayLow" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="StockVolume" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PrevCls" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ChangePercent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FiftyTwoWeekRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EarnPerShare" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QuoteError" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuoteData", propOrder = {
    "stockSymbol",
    "lastTradeAmount",
    "lastTradeDateTime",
    "stockChange",
    "openAmount",
    "dayHigh",
    "dayLow",
    "stockVolume",
    "prevCls",
    "changePercent",
    "fiftyTwoWeekRange",
    "earnPerShare",
    "pe",
    "companyName",
    "quoteError"
})
public class QuoteData {

    @XmlElement(name = "StockSymbol")
    protected String stockSymbol;
    @XmlElement(name = "LastTradeAmount", required = true)
    protected BigDecimal lastTradeAmount;
    @XmlElement(name = "LastTradeDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastTradeDateTime;
    @XmlElement(name = "StockChange", required = true)
    protected BigDecimal stockChange;
    @XmlElement(name = "OpenAmount", required = true)
    protected BigDecimal openAmount;
    @XmlElement(name = "DayHigh", required = true)
    protected BigDecimal dayHigh;
    @XmlElement(name = "DayLow", required = true)
    protected BigDecimal dayLow;
    @XmlElement(name = "StockVolume")
    protected int stockVolume;
    @XmlElement(name = "PrevCls", required = true)
    protected BigDecimal prevCls;
    @XmlElement(name = "ChangePercent")
    protected String changePercent;
    @XmlElement(name = "FiftyTwoWeekRange")
    protected String fiftyTwoWeekRange;
    @XmlElement(name = "EarnPerShare", required = true)
    protected BigDecimal earnPerShare;
    @XmlElement(name = "PE", required = true)
    protected BigDecimal pe;
    @XmlElement(name = "CompanyName")
    protected String companyName;
    @XmlElement(name = "QuoteError")
    protected boolean quoteError;

    /**
     * Obtient la valeur de la propri�t� stockSymbol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStockSymbol() {
        return stockSymbol;
    }

    /**
     * D�finit la valeur de la propri�t� stockSymbol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStockSymbol(String value) {
        this.stockSymbol = value;
    }

    /**
     * Obtient la valeur de la propri�t� lastTradeAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLastTradeAmount() {
        return lastTradeAmount;
    }

    /**
     * D�finit la valeur de la propri�t� lastTradeAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLastTradeAmount(BigDecimal value) {
        this.lastTradeAmount = value;
    }

    /**
     * Obtient la valeur de la propri�t� lastTradeDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastTradeDateTime() {
        return lastTradeDateTime;
    }

    /**
     * D�finit la valeur de la propri�t� lastTradeDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastTradeDateTime(XMLGregorianCalendar value) {
        this.lastTradeDateTime = value;
    }

    /**
     * Obtient la valeur de la propri�t� stockChange.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStockChange() {
        return stockChange;
    }

    /**
     * D�finit la valeur de la propri�t� stockChange.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStockChange(BigDecimal value) {
        this.stockChange = value;
    }

    /**
     * Obtient la valeur de la propri�t� openAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpenAmount() {
        return openAmount;
    }

    /**
     * D�finit la valeur de la propri�t� openAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpenAmount(BigDecimal value) {
        this.openAmount = value;
    }

    /**
     * Obtient la valeur de la propri�t� dayHigh.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    /**
     * D�finit la valeur de la propri�t� dayHigh.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDayHigh(BigDecimal value) {
        this.dayHigh = value;
    }

    /**
     * Obtient la valeur de la propri�t� dayLow.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDayLow() {
        return dayLow;
    }

    /**
     * D�finit la valeur de la propri�t� dayLow.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDayLow(BigDecimal value) {
        this.dayLow = value;
    }

    /**
     * Obtient la valeur de la propri�t� stockVolume.
     * 
     */
    public int getStockVolume() {
        return stockVolume;
    }

    /**
     * D�finit la valeur de la propri�t� stockVolume.
     * 
     */
    public void setStockVolume(int value) {
        this.stockVolume = value;
    }

    /**
     * Obtient la valeur de la propri�t� prevCls.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrevCls() {
        return prevCls;
    }

    /**
     * D�finit la valeur de la propri�t� prevCls.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrevCls(BigDecimal value) {
        this.prevCls = value;
    }

    /**
     * Obtient la valeur de la propri�t� changePercent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangePercent() {
        return changePercent;
    }

    /**
     * D�finit la valeur de la propri�t� changePercent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangePercent(String value) {
        this.changePercent = value;
    }

    /**
     * Obtient la valeur de la propri�t� fiftyTwoWeekRange.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiftyTwoWeekRange() {
        return fiftyTwoWeekRange;
    }

    /**
     * D�finit la valeur de la propri�t� fiftyTwoWeekRange.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiftyTwoWeekRange(String value) {
        this.fiftyTwoWeekRange = value;
    }

    /**
     * Obtient la valeur de la propri�t� earnPerShare.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEarnPerShare() {
        return earnPerShare;
    }

    /**
     * D�finit la valeur de la propri�t� earnPerShare.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEarnPerShare(BigDecimal value) {
        this.earnPerShare = value;
    }

    /**
     * Obtient la valeur de la propri�t� pe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPE() {
        return pe;
    }

    /**
     * D�finit la valeur de la propri�t� pe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPE(BigDecimal value) {
        this.pe = value;
    }

    /**
     * Obtient la valeur de la propri�t� companyName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * D�finit la valeur de la propri�t� companyName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Obtient la valeur de la propri�t� quoteError.
     * 
     */
    public boolean isQuoteError() {
        return quoteError;
    }

    /**
     * D�finit la valeur de la propri�t� quoteError.
     * 
     */
    public void setQuoteError(boolean value) {
        this.quoteError = value;
    }

}
