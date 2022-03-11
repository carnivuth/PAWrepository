package it.unibo.paw;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;




public class MainSAX {

	public static void main(String[] args) {
		
		
		try {
			
			SAXParserFactory dbf= SAXParserFactory.newInstance();
			dbf.setValidating(true);
			SAXParser db=dbf.newSAXParser();
			//ErrorHandler eh=new ErrorHandler();
			PersoneHandler eh =new PersoneHandler();
			XMLReader r=db.getXMLReader();
			r.setErrorHandler(eh);
			r.setContentHandler(eh);
			r.parse("resources/AddressList.xml");
			System.out.println(eh.getnPersone());
		
		} catch (ParserConfigurationException e) {
		
			e.printStackTrace();
		} catch (SAXException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		

	}

}
