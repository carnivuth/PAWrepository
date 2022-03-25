package it.unibo.paw.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import it.unibo.paw.db.DataSource;
import it.unibo.paw.db.PrenotazioneRepository;

//classe di test interfacciamento con l'utente via terminale
public class PrenotazioneRistorante {

	public static void main(String[] args) {
		BufferedReader r =new BufferedReader(new InputStreamReader(System.in));
		PrenotazioneRepository pr=new PrenotazioneRepository(DataSource.DB2); 
		String op=null;
		String cognome=null;
		String cellulare=null;
		int numeroPersone;
		Date data=null;
		
		System.out.println("selezionare operazione: 1)inserimento prenotazione , ^D)terminare");
		try {
			while((op=r.readLine())!=null) {
				
				if(op=="1") {
					System.out.println("inserire cognome");
					cognome=r.readLine();
					System.out.println("inserire cellulare");
					cellulare=r.readLine();
					System.out.println("inserire numero di persone");
					numeroPersone=Integer.parseInt(r.readLine());
					System.out.println("inserire data in formato yyyy-mm-dd");
					data =Date.valueOf(r.readLine());
					if(pr.RichiestaPrenotazione(cognome, data, numeroPersone, cellulare)) {
						System.out.println("inserimento riuscito");
					}else {
						System.out.println("inserimento non riuscito");
					}
				}
				System.out.println("selezionare operazione: 1)inserimento prenotazione , ^D)terminare");	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(r!=null) {
				try {
					r.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
