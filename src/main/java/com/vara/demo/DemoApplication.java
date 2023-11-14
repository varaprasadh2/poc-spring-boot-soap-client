package com.vara.demo;

import com.vara.demo.client.gen.CapitalCityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	CapitalCityClient capitalCityClient;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}




	@GetMapping("/")
	public CapitalCityResponse hello(@RequestParam(name = "q", defaultValue = "world") String name){
		return capitalCityClient.getCountry("US");
	}
}
