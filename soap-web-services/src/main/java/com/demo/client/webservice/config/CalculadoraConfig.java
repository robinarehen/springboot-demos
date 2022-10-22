package com.demo.client.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.demo.client.webservice.service.WebServiceConnector;

@Configuration
public class CalculadoraConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.demo.client.webservice.wsdl");
		return marshaller;
	}
	
	@Bean
	public WebServiceConnector webServiceConnector(Jaxb2Marshaller marshaller) {
		
		WebServiceConnector webServiceConnector = new WebServiceConnector();
		webServiceConnector.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		webServiceConnector.setMarshaller(marshaller);
		webServiceConnector.setUnmarshaller(marshaller);
		return webServiceConnector;
	}
}
