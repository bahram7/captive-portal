package org.sohagroup.bsi.smsservice.service;

import org.junit.jupiter.api.Test;
import org.sohagroup.bsi.smsservice.IntegrationTest;
import org.sohagroup.bsi.smsservice.service.dto.SendSMSSingleDTO;
import org.sohagroup.bsi.smsservice.tempuri.ArrayOfString;
import org.sohagroup.bsi.smsservice.tempuri.SendSMSSingleResponse;
import org.sohagroup.bsi.smsservice.web.rest.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@AutoConfigureMockMvc
@IntegrationTest
class SmsServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sendSmsSingle() throws Exception {
        SendSMSSingleDTO dto = new SendSMSSingleDTO();
        dto.setCompany("soha");
        dto.setIpSend("http...");
        dto.setMessage("hi");
        dto.setDestinationAddress("tehran");
        dto.setNumber("123");
        dto.setUserName("b.soltani");
        dto.setFlash(true);
        dto.setPassword("password");

        mockMvc
            .perform(
                MockMvcRequestBuilders
                    .post("/api/sendSmsSingle")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dto))
            );
    }

    //    @Test
    public void marshalingExample() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(SendSMSSingleResponse.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        SendSMSSingleResponse sendSMSSingleResponse = new SendSMSSingleResponse();
        ArrayOfString arrayOfString = new ArrayOfString();
        List<String> stringList = new ArrayList<>();
        stringList.add("iman");
        stringList.add("bahram");
        arrayOfString.setString(stringList);
        sendSMSSingleResponse.setSendSMSSingleResult(arrayOfString);
        jaxbMarshaller.marshal(sendSMSSingleResponse, new File("/home/bahram/Desktop/sms/src/test/resources/sendSMSSingleDTO.xml"));
    }
}
