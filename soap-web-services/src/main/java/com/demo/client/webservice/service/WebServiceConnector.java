package com.demo.client.webservice.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WebServiceConnector extends WebServiceGatewaySupport  {
	
	public Object callWebService(String url, Object request, String soapAction) {
		return this.getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback(soapAction));
	}
}
