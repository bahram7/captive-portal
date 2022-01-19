package org.sohagroup.bsi.smsservice.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for ArrayOfSTC_SMSStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ArrayOfSTC_SMSStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="STC_SMSStatus" type="{http://tempuri.org/}STC_SMSStatus" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSTC_SMSStatus", propOrder = { "stcsmsStatus" })
public class ArrayOfSTCSMSStatus {

    @XmlElement(name = "STC_SMSStatus", nillable = true)
    protected List<STCSMSStatus> stcsmsStatus;

    /**
     * Gets the value of the stcsmsStatus property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stcsmsStatus property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTCSMSStatus().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link STCSMSStatus }
     *
     *
     */
    public List<STCSMSStatus> getSTCSMSStatus() {
        if (stcsmsStatus == null) {
            stcsmsStatus = new ArrayList<STCSMSStatus>();
        }
        return this.stcsmsStatus;
    }
}
