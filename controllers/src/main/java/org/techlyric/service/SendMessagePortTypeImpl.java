package org.techlyric.service;
 
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(
	portName="SendMessagePortType",
	serviceName = "sendmessage",
	targetNamespace="http://org.techlyric",
	endpointInterface="org.techlyric.service.SendMessagePortType")
public class SendMessagePortTypeImpl implements SendMessagePortType {
	
	@Resource
	private WebServiceContext context;
	//MessageContext ctx = context.getMessageContext();
	//HttpServletRequest request = (HttpServletRequest)ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
	//HttpServletResponse response = (HttpServletResponse)    ctx.get(AbstractHTTPDestination.HTTP_RESPONSE);
	@Override
	public SendMessagePortResponse SendMessage(ExtractionMessage extract){
		return new SendMessagePortResponse();
	}
}
