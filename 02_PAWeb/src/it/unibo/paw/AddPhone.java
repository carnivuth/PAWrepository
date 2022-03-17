package it.unibo.paw;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xmlUtils.XmlLoader;

public class AddPhone {

	public static void main(String[] args) {
		try {	
			Document doc=XmlLoader.docLoader("resources/AddressList.xml");
			
			//recupero root element
			Node root= doc.getElementsByTagName("Address_list").item(0);
			NodeList firstNames;
			firstNames=doc.getElementsByTagName("firstname");
			Element e=doc.createElement("Telephone");
			
			//main cycle
			for(int i =0; i <firstNames.getLength();i++) {
				
				if(firstNames.item(i).getTextContent().equals(args[0])) {
					Node information=firstNames.item(i).getParentNode().getParentNode();
					information.appendChild(e);
				}
				
				
			}
	
		} catch (ParserConfigurationException e) {
		
			e.printStackTrace();
		} catch (SAXException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}
}


