package xmlUtils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlLoader {
	public static Document docLoader(String filename)throws ParserConfigurationException,SAXException,IOException  {
		//factory and builder setup
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		db.setErrorHandler(new DefaultHandler());
		//document parsing
		Document doc=db.parse(new File(filename));
		return doc;
	
		
	}
	
	
}
