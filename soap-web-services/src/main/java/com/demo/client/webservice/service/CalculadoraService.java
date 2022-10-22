package com.demo.client.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.client.webservice.wsdl.Add;
import com.demo.client.webservice.wsdl.AddResponse;
import com.demo.client.webservice.wsdl.Subtract;
import com.demo.client.webservice.wsdl.SubtractResponse;

@Service
public class CalculadoraService {

	@Autowired
	private WebServiceConnector webServiceConnector;
	
	private String urlWebService = "http://www.dneonline.com/calculator.asmx";
	private String soapAction = "http://tempuri.org"; 

	public Integer sumar(int numberA, int numberB) {
		Add add = new Add();
		add.setIntA(numberA);
		add.setIntB(numberB);
		String urlMethod = String.format("%s/Add",this.soapAction);
		AddResponse addResponse = (AddResponse) this.webServiceConnector.callWebService(this.urlWebService, add, urlMethod);
		return addResponse.getAddResult();
	}
	
	public Integer restar(int numberA, int numberB) {
		Subtract add = new Subtract();
		add.setIntA(numberA);
		add.setIntB(numberB);
		String urlMethod = String.format("%s/Subtract",this.soapAction);
		SubtractResponse addResponse = (SubtractResponse) this.webServiceConnector.callWebService(this.urlWebService, add, urlMethod);
		return addResponse.getSubtractResult();
	}
}
