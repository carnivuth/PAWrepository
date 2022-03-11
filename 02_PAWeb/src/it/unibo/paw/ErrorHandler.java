package it.unibo.paw;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ErrorHandler extends DefaultHandler {
	private int ignorableCh;
	
	public ErrorHandler() {
		this.setIgnorableCh(0);
	}
	
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		this.setIgnorableCh(this.getIgnorableCh()+length);
		
	}

	public int getIgnorableCh() {
		return ignorableCh;
	}

	public void setIgnorableCh(int ignorableCh) {
		this.ignorableCh = ignorableCh;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		for(int i=0;i<length;i++) {
			if(ch[i]==' ') {
				this.setIgnorableCh(this.getIgnorableCh()+1);
				
			}
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(this.getIgnorableCh());
	}
	
	

}
