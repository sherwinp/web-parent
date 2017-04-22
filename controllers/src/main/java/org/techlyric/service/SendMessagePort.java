package org.techlyric.service;
 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Endpoint
public class SendMessagePort {
	private static final String NAMESPACE_URI = "http://org.techlyric";
	//MessageContext ctx = context.getMessageContext();
	//HttpServletRequest request = (HttpServletRequest)ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
	//HttpServletResponse response = (HttpServletResponse)    ctx.get(AbstractHTTPDestination.HTTP_RESPONSE);
	public SendMessagePort(){
		
	}
	@PayloadRoot(localPart = "SendMessage", namespace = "http://org.techlyric")
    @ResponsePayload
    public Element SendMessage(@RequestPayload Element request) throws ParserConfigurationException, SOAPException {
    	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element messageElement = document.createElementNS(NAMESPACE_URI, "SendMessageResponse");
		return messageElement;
	}
}
