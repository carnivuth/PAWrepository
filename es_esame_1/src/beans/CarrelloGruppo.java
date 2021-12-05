package beans;

import java.util.ArrayList;
import java.util.List;

public class CarrelloGruppo {
	
	private List<Prodotto> items;
	private List<String> utenti;
	
	public CarrelloGruppo() {
		this.items=new ArrayList<Prodotto>();
		this.utenti=new ArrayList<String>();
	}

	public List<Prodotto> getItems() {
		return items;
	}

	public void setItems(List<Prodotto> items) {
		this.items = items;
	}

	public List<String> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<String> utenti) {
		this.utenti = utenti;
	}
	

}
