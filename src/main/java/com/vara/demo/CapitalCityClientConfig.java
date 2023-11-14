package com.vara.demo;


import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.vara.demo.client.gen.CapitalCity;
import com.vara.demo.client.gen.CapitalCityResponse;

import jakarta.xml.bind.Marshaller;


@Configuration
public class CapitalCityClientConfig {

    @Bean
    Jaxb2Marshaller marshaller() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // marshaller.setContextPath("com.vara.demo.client.gen");
        marshaller.setClassesToBeBound(new Class[] { CapitalCity.class, CapitalCityResponse.class });
        marshaller.setMarshallerProperties(properties);
        // marshaller.setPackagesToScan("com.vara.demo.client.gen");
        return marshaller;
    }

	// @Bean
    // public Marshaller marshaller() throws JAXBException {
    //     // Create a JAXBContext for your JAXB-annotated classes
    //     JAXBContext context = JAXBContext.newInstance(CapitalCity.class, CapitalCityResponse.class);

    //     // Create a Marshaller
    //     Marshaller marshaller = context.createMarshaller();
    //     // Configure marshaller properties if needed
    //     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    //     return marshaller;
    // }

	@Bean
	CapitalCityClient countryClient(Jaxb2Marshaller marshaller) {
		CapitalCityClient client = new CapitalCityClient();
		client.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
