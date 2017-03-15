package org.techlyric.service;
 
import javax.jws.WebService;
 
@WebService
public class SendMessagePortTypeImpl implements SendMessagePortType {
	@Override
	public SendMessagePortResponse SendMessage(ExtractionMessage extract){
		return new SendMessagePortResponse();
	}
}
