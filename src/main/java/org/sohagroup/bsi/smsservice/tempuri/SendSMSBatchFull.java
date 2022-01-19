package org.sohagroup.bsi.smsservice.tempuri;

import javax.xml.bind.annotation.*;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DestinationAddress" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IP_Send" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsFlash" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="SendStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BatchID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chargingAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {
        "message",
        "destinationAddress",
        "number",
        "userName",
        "password",
        "ipSend",
        "company",
        "isFlash",
        "sendStatus",
        "batchID",
        "amount",
        "chargingAmount",
    }
)
@XmlRootElement(name = "SendSMS_Batch_Full")
public class SendSMSBatchFull {

    @XmlElement(name = "Message")
    protected String message;

    @XmlElement(name = "DestinationAddress")
    protected ArrayOfString destinationAddress;

    @XmlElement(name = "Number")
    protected String number;

    protected String userName;
    protected String password;

    @XmlElement(name = "IP_Send")
    protected String ipSend;

    @XmlElement(name = "Company")
    protected String company;

    @XmlElement(name = "IsFlash")
    protected boolean isFlash;

    @XmlElement(name = "SendStatus")
    protected String sendStatus;

    @XmlElement(name = "BatchID")
    protected String batchID;

    @XmlElement(name = "Amount")
    protected String amount;

    protected String chargingAmount;

    /**
     * Gets the value of the message property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the destinationAddress property.
     *
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *
     */
    public ArrayOfString getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * Sets the value of the destinationAddress property.
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *
     */
    public void setDestinationAddress(ArrayOfString value) {
        this.destinationAddress = value;
    }

    /**
     * Gets the value of the number property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the userName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the ipSend property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIPSend() {
        return ipSend;
    }

    /**
     * Sets the value of the ipSend property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIPSend(String value) {
        this.ipSend = value;
    }

    /**
     * Gets the value of the company property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the isFlash property.
     *
     */
    public boolean isIsFlash() {
        return isFlash;
    }

    /**
     * Sets the value of the isFlash property.
     *
     */
    public void setIsFlash(boolean value) {
        this.isFlash = value;
    }

    /**
     * Gets the value of the sendStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSendStatus() {
        return sendStatus;
    }

    /**
     * Sets the value of the sendStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSendStatus(String value) {
        this.sendStatus = value;
    }

    /**
     * Gets the value of the batchID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * Sets the value of the batchID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBatchID(String value) {
        this.batchID = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the chargingAmount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getChargingAmount() {
        return chargingAmount;
    }

    /**
     * Sets the value of the chargingAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setChargingAmount(String value) {
        this.chargingAmount = value;
    }
}
