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
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IP_Send" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BatchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "userName", "password", "ipSend", "company", "batchId" })
@XmlRootElement(name = "StatusSMS")
public class StatusSMS {

    @XmlElement(name = "UserName")
    protected String userName;

    @XmlElement(name = "Password")
    protected String password;

    @XmlElement(name = "IP_Send")
    protected String ipSend;

    @XmlElement(name = "Company")
    protected String company;

    @XmlElement(name = "BatchId")
    protected String batchId;

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
     * Gets the value of the batchId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * Sets the value of the batchId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBatchId(String value) {
        this.batchId = value;
    }
}
