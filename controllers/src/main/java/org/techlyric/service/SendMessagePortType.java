package org.techlyric.service;

import javax.jws.WebService;

@WebService(targetNamespace = "http://techlyric.org")
public interface SendMessagePortType {
	public SendMessagePortResponse SendMessage(ExtractionMessage extract);
}
