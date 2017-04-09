package org.techlyric.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://org.techlyric")
public interface SendMessagePortType {
	@WebMethod public SendMessagePortResponse SendMessage(ExtractionMessage extract);
}
