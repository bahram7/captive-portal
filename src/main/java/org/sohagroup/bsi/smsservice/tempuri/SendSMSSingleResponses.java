package org.sohagroup.bsi.smsservice.tempuri;//package org.sohagroup.sms.tempuri;
//
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "SendSMS_SingleResponses")
//public class SendSMSSingleResponses {
//
//    @XmlElement(name = "SendSMS_SingleResponse")
//private List<SendSMSSingleResponse> sendSMSSingleResponseList;
//
//    public List<SendSMSSingleResponse> getSendSMSSingleResponseList() {
//        return sendSMSSingleResponseList;
//    }
//
//    public void setSendSMSSingleResponseList(List<SendSMSSingleResponse> sendSMSSingleResponseList) {
//        this.sendSMSSingleResponseList = sendSMSSingleResponseList;
//    }
//
//
//    static SendSMSSingleResponses sendSMSSingleResponses = new SendSMSSingleResponses();
//    static
//    {
//        sendSMSSingleResponses.setSendSMSSingleResponseList(new ArrayList<SendSMSSingleResponse>());
//        //Create two employees
//        SendSMSSingleResponse sendSMSSingleResponse1 = new SendSMSSingleResponse();
//        sendSMSSingleResponse1.setSendSMSSingleResult(null);
//
//
//        SendSMSSingleResponse sendSMSSingleResponse2 = new SendSMSSingleResponse();
//        sendSMSSingleResponse2.setSendSMSSingleResult(null);
//
//        //Add the employees in list
//        sendSMSSingleResponses.getSendSMSSingleResponseList().add(sendSMSSingleResponse1);
//        sendSMSSingleResponses.getSendSMSSingleResponseList().add(sendSMSSingleResponse2);
//    }
//
//    private static void marshalingExample() throws JAXBException
//    {
//        JAXBContext jaxbContext = JAXBContext.newInstance(SendSMSSingleResponses.class);
//        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        //Marshal the employees list in console
//        jaxbMarshaller.marshal(sendSMSSingleResponses, System.out);
//
//        //Marshal the employees list in file
//        jaxbMarshaller.marshal(sendSMSSingleResponses, new File("c:/temp/employees.xml"));
//    }
//
//
//
//}
