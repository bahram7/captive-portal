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
 *         &lt;element name="SendSMS_SingleResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "sendSMSSingleResult" })
@XmlRootElement(name = "SendSMS_SingleResponse")
public class SendSMSSingleResponse {

    @XmlElement(name = "SendSMS_SingleResult")
    protected ArrayOfString sendSMSSingleResult;

    /**
     * Gets the value of the sendSMSSingleResult property.
     *
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *
     */
    public ArrayOfString getSendSMSSingleResult() {
        return sendSMSSingleResult;
    }

    /**
     * Sets the value of the sendSMSSingleResult property.
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *
     */
    public void setSendSMSSingleResult(ArrayOfString value) {
        this.sendSMSSingleResult = value;
    }
}
