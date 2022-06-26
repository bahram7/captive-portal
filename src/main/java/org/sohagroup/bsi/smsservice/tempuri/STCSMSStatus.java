package org.sohagroup.bsi.smsservice.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for STC_SMSStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="STC_SMSStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ReceiveNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STC_SMSStatus", propOrder = { "receiveNumber", "deliveryStatus", "time" })
public class STCSMSStatus {

    @XmlElement(name = "ReceiveNumber")
    protected String receiveNumber;

    @XmlElement(name = "DeliveryStatus")
    protected String deliveryStatus;

    @XmlElement(name = "Time")
    protected String time;

    /**
     * Gets the value of the receiveNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReceiveNumber() {
        return receiveNumber;
    }

    /**
     * Sets the value of the receiveNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReceiveNumber(String value) {
        this.receiveNumber = value;
    }

    /**
     * Gets the value of the deliveryStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * Sets the value of the deliveryStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeliveryStatus(String value) {
        this.deliveryStatus = value;
    }

    /**
     * Gets the value of the time property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTime(String value) {
        this.time = value;
    }
}
