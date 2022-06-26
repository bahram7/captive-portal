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
 *         &lt;element name="SendSMS_LikeToLikeResult" type="{http://tempuri.org/}ArrayOfSTC_SMSSend" minOccurs="0"/&gt;
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
@XmlType(name = "", propOrder = { "sendSMSLikeToLikeResult", "sendStatus", "batchID", "amount", "chargingAmount" })
@XmlRootElement(name = "SendSMS_LikeToLikeResponse")
public class SendSMSLikeToLikeResponse {

    @XmlElement(name = "SendSMS_LikeToLikeResult")
    protected ArrayOfSTCSMSSend sendSMSLikeToLikeResult;

    @XmlElement(name = "SendStatus")
    protected String sendStatus;

    @XmlElement(name = "BatchID")
    protected String batchID;

    @XmlElement(name = "Amount")
    protected String amount;

    protected String chargingAmount;

    /**
     * Gets the value of the sendSMSLikeToLikeResult property.
     *
     * @return
     *     possible object is
     *     {@link ArrayOfSTCSMSSend }
     *
     */
    public ArrayOfSTCSMSSend getSendSMSLikeToLikeResult() {
        return sendSMSLikeToLikeResult;
    }

    /**
     * Sets the value of the sendSMSLikeToLikeResult property.
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfSTCSMSSend }
     *
     */
    public void setSendSMSLikeToLikeResult(ArrayOfSTCSMSSend value) {
        this.sendSMSLikeToLikeResult = value;
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
