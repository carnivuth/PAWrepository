package it.unibo.paw.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;

import it.unibo.paw.db.DataSource;
import it.unibo.paw.db.PersistenceException;
import it.unibo.paw.db.PrenotazioneRepository;
import it.unibo.paw.db.TavoliRepository;
import it.unibo.paw.model.Prenotazione;

public class dbMaker {

	public static void main(String[] args) {
		BufferedReader r =new BufferedReader(new InputStreamReader(System.in));
		PrenotazioneRepository pr=new PrenotazioneRepository(DataSource.DB2);
		TavoliRepository tr=new TavoliRepository(DataSource.DB2);
		String op=null;
		List<Prenotazione> lp;
		System.out.println("selezionare operazione crud: 1)create, 2)read, 3)update, 4)delete ^D)terminare");
		try {
			while((op=r.readLine())!=null) {

				switch(op) {
				
				case "1":
					pr.dropAndCreateTablePrenotazioni();
					tr.dropAndCreateTableTavoli();
					System.out.println("creazione avvenuta con successo");
					break;
				
				case "2":
					
					lp=pr.findAll();
					for(Prenotazione p:lp) {
						System.out.println(p.toString());
					}
					break;
				
				case "3":
				
					System.out.println("placeholder");
					break;
				
				case "4":
					
					System.out.println("placeholder");
					break;
				
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
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
