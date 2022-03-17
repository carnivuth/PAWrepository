package it.unibo.paw;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import xmlUtils.XmlLoader;


public class MainDOM {

	public static void main(String[] args) {
		try {	
			int nPersone=0;
			int nPersoneBeforeMickey=0;
			boolean afterMickey=false;
			Document doc=XmlLoader.docLoader("resources/AddressList.xml");
			
			//recupero root element
			Node root= doc.getElementsByTagName("Address_list").item(0);
			Node information;
			//main cycle
			for(int i =0; i <root.getChildNodes().getLength();i++) {
				
				information =root.getChildNodes().item(i);
				
				if(information!=null) {
						
					if( information.getNodeName().equals("Information")) {
					
						nPersone++;

						if(information.getChildNodes().item(1).
								getChildNodes().item(1).getTextContent().equals("Mickey")) {
							afterMickey=true;
						}
						if(!afterMickey)nPersoneBeforeMickey++;
						
					}
					
					
					
				}
			}
			
			System.out.println(nPersone);
			System.out.println(nPersoneBeforeMickey);
	
		} catch (ParserConfigurationException e) {
		
			e.printStackTrace();
		} catch (SAXException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

}
