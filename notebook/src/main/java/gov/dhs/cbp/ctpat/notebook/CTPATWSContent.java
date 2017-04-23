package gov.dhs.cbp.ctpat.notebook;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.TreeItem;
import netscape.javascript.JSObject;

public class CTPATWSContent extends Task<ObservableList<Object>> {
	private InputSource is = null;
	private DefaultHandler handler=null;
	private IContentListener listener=null;
	
	TreeItem<String> contentRoot = new TreeItem<String>("Visit Worksheet");
	
	StringBuilder charBuffer=new StringBuilder();
	String elementName;
	
	public void setDefaultHandler(DefaultHandler handler){
		this.handler = handler;
	}
	public DefaultHandler getDefaultHandler(){
		return this.handler;
	}
	
	public CTPATWSContent(InputStream inputStream, IContentListener listener) throws UnsupportedEncodingException {
		this.listener=listener;
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		is = new InputSource(reader);
		is.setEncoding("UTF-8");
	}

	public void reader() {
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			saxParser.parse(is, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class CTPATWSContentSummary extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			charBuffer.setLength(0);
			elementName = qName;
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			super.endElement(uri, localName, qName);
			
			contentRoot.getChildren().add(new TreeItem<String>(qName));
			System.out.println(charBuffer.toString());
		}

		@Override
		public void characters(char ch[], int start, int length) throws SAXException {
			super.characters(ch, start, length);
			charBuffer.append(ch, start, length);
		}

	}

	@Override
	protected ObservableList<Object> call() throws Exception {
		ObservableList<Object> results = FXCollections.observableArrayList();
		this.reader();
		contentRoot.setExpanded(true);
		results.add(contentRoot);
		Platform.runLater(new Runnable() {
            @Override public void run() {
            	listener.summary(results);
            }
        });
        
		return results;
	}

}
