package org.sohagroup.bsi.smsservice.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for ArrayOfSTC_SMSSend complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ArrayOfSTC_SMSSend"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="STC_SMSSend" type="{http://tempuri.org/}STC_SMSSend" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSTC_SMSSend", propOrder = { "stcsmsSend" })
public class ArrayOfSTCSMSSend {

    @XmlElement(name = "STC_SMSSend", nillable = true)
    protected List<STCSMSSend> stcsmsSend;

    /**
     * Gets the value of the stcsmsSend property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stcsmsSend property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTCSMSSend().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link STCSMSSend }
     *
     *
     */
    public List<STCSMSSend> getSTCSMSSend() {
        if (stcsmsSend == null) {
            stcsmsSend = new ArrayList<STCSMSSend>();
        }
        return this.stcsmsSend;
    }
}
