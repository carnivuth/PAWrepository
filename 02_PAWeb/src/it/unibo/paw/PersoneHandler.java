package it.unibo.paw;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersoneHandler extends DefaultHandler {
	
	private int nPersone;
	
	public PersoneHandler() {
		this.nPersone=0;
	}
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		//System.out.println(qName);
		if(qName.equals("First_name"))nPersone++;
	}


	public int getnPersone() {
		return nPersone;
	}


	public void setnPersone(int nPersone) {
		this.nPersone = nPersone;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(this.getnPersone());
	}
	
	
	
	
	
	
	
	
	
	
	
}
