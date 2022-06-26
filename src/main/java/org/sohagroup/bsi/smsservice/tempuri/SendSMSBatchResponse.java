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
 *         &lt;element name="SendSMS_BatchResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "sendSMSBatchResult" })
@XmlRootElement(name = "SendSMS_BatchResponse")
public class SendSMSBatchResponse {

    @XmlElement(name = "SendSMS_BatchResult")
    protected ArrayOfString sendSMSBatchResult;

    /**
     * Gets the value of the sendSMSBatchResult property.
     *
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *
     */
    public ArrayOfString getSendSMSBatchResult() {
        return sendSMSBatchResult;
    }

    /**
     * Sets the value of the sendSMSBatchResult property.
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *
     */
    public void setSendSMSBatchResult(ArrayOfString value) {
        this.sendSMSBatchResult = value;
    }
}
