package org.techlyric.service;
 
import javax.annotation.Resource;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import weblogic.jws.Policies;
import weblogic.jws.Policy;

@WebService(
	portName="SendMessagePortType",
	serviceName = "sendmessage",
	targetNamespace="http://org.techlyric",
	endpointInterface="org.techlyric.service.SendMessagePortType")
@Policy(uri="Wssp1.2-2007-Wss1.1-X509-Basic256.xml")
public class SendMessagePortTypeImpl implements SendMessagePortType {
	
	@Resource
	private WebServiceContext context;
	//MessageContext ctx = context.getMessageContext();
	//HttpServletRequest request = (HttpServletRequest)ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
	//HttpServletResponse response = (HttpServletResponse)    ctx.get(AbstractHTTPDestination.HTTP_RESPONSE);
	@Oneway @WebMethod
	@Override
	public SendMessagePortResponse SendMessage(ExtractionMessage extract){
	    	
		return new SendMessagePortResponse();
	}
}
