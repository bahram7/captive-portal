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
 *         &lt;element name="StatusSMSResult" type="{http://tempuri.org/}ArrayOfSTC_SMSStatus" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "statusSMSResult" })
@XmlRootElement(name = "StatusSMSResponse")
public class StatusSMSResponse {

    @XmlElement(name = "StatusSMSResult")
    protected ArrayOfSTCSMSStatus statusSMSResult;

    /**
     * Gets the value of the statusSMSResult property.
     *
     * @return
     *     possible object is
     *     {@link ArrayOfSTCSMSStatus }
     *
     */
    public ArrayOfSTCSMSStatus getStatusSMSResult() {
        return statusSMSResult;
    }

    /**
     * Sets the value of the statusSMSResult property.
     *
     * @param value
     *     allowed object is
     *     {@link ArrayOfSTCSMSStatus }
     *
     */
    public void setStatusSMSResult(ArrayOfSTCSMSStatus value) {
        this.statusSMSResult = value;
    }
}
