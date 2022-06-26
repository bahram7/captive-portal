package org.sohagroup.bsi.smsservice.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for STC_SMSSend complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="STC_SMSSend"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SourceAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DestAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SMSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STC_SMSSend", propOrder = { "sourceAddress", "destAddress", "status", "response", "smsid" })
public class STCSMSSend {

    @XmlElement(name = "SourceAddress")
    protected String sourceAddress;

    @XmlElement(name = "DestAddress")
    protected String destAddress;

    @XmlElement(name = "Status")
    protected String status;

    @XmlElement(name = "Response")
    protected String response;

    @XmlElement(name = "SMSID")
    protected String smsid;

    /**
     * Gets the value of the sourceAddress property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSourceAddress() {
        return sourceAddress;
    }

    /**
     * Sets the value of the sourceAddress property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSourceAddress(String value) {
        this.sourceAddress = value;
    }

    /**
     * Gets the value of the destAddress property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDestAddress() {
        return destAddress;
    }

    /**
     * Sets the value of the destAddress property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDestAddress(String value) {
        this.destAddress = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the response property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setResponse(String value) {
        this.response = value;
    }

    /**
     * Gets the value of the smsid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSMSID() {
        return smsid;
    }

    /**
     * Sets the value of the smsid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSMSID(String value) {
        this.smsid = value;
    }
}
