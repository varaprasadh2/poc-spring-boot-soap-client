package com.vara.demo;

import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

public class LoggingInterceptor2 implements ClientInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        // Log request details here
        System.out.println("Request: " + messageContext.getRequest());
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        // Log response details here
        System.out.println("Response: " + messageContext.getResponse());
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) {
        // Log fault details here
        System.out.println("Fault: " + messageContext.getResponse());
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception ex) {
        // Cleanup or additional logging if needed
    }
}

