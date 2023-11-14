package com.vara.demo;

import com.vara.demo.client.gen.CapitalCity;
import com.vara.demo.client.gen.CapitalCityResponse;
import com.vara.demo.client.gen.ObjectFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

public class CapitalCityClient extends WebServiceGatewaySupport {

    public CapitalCityResponse getCountry(String country) {
        // Use SaajSoapMessageFactory explicitly
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.afterPropertiesSet();

        // Create a SaajSoapMessage and set the appropriate namespace declaration
        SaajSoapMessage request = messageFactory.createWebServiceMessage();
        request.getEnvelope().addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");

        ObjectFactory objectFactory = new ObjectFactory();
        CapitalCity capitalCity = objectFactory.createCapitalCity();
        // Manually set the request parameters
        CapitalCity capitalCityRequest = new CapitalCity();
        capitalCityRequest.setSCountryISOCode("US");

        // Use the SaajSoapMessage for the request
        Object object = getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(), capitalCityRequest, new LoggingInterceptor());


        System.out.println(object);
        System.out.println("debug");
        CapitalCityResponse response = (CapitalCityResponse) object;
        return response;
    }
}
