package it.unibo.paw;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MainDOM {

	public static void main(String[] args) {
try {
			int nPersone=0;
			DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			DocumentBuilder db=dbf.newDocumentBuilder();
			db.setErrorHandler(new DefaultHandler());
			Document doc=db.parse(new File("resources/AddressList.xml"));
			
			for(int i =0; i <doc.getChildNodes().getLength();i++) {
				Node n =doc.getChildNodes().item(i);
				if(n!=null) {
					System.out.println(n.getNodeName());
					if( n.getNodeName().equals("Information"))nPersone++;
		
				}
			}
			System.out.println(nPersone);
			
			
		} catch (ParserConfigurationException e) {
		
			e.printStackTrace();
		} catch (SAXException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

}
