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
 *         &lt;element name="GetRemainCreditResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getRemainCreditResult" })
@XmlRootElement(name = "GetRemainCreditResponse")
public class GetRemainCreditResponse {

    @XmlElement(name = "GetRemainCreditResult")
    protected String getRemainCreditResult;

    /**
     * Gets the value of the getRemainCreditResult property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGetRemainCreditResult() {
        return getRemainCreditResult;
    }

    /**
     * Sets the value of the getRemainCreditResult property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGetRemainCreditResult(String value) {
        this.getRemainCreditResult = value;
    }
}
