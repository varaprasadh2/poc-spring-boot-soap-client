package com.vara.demo;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class LoggingInterceptor implements WebServiceMessageCallback {

    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException {
        // Log the request message
        System.out.println("Outgoing request message: " + message.getPayloadSource().toString());
        System.out.println("Outgoing request message: " + message.getPayloadResult().toString());
        System.out.println("Outgoing request message: " + message.toString());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        message.writeTo(byteArrayOutputStream);
        System.out.println("debug:--?: " + new String(byteArrayOutputStream.toByteArray()));
        // You can also log the message details if needed
        // System.out.println("Message details: " + message.toString());
    }
}
