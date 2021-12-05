package beans;

import java.util.ArrayList;
import java.util.List;

public class ListaCarrelli {
	private List<CarrelloGruppo> carrelli;
	public ListaCarrelli() {
		carrelli=new ArrayList<CarrelloGruppo>();
	}
	public List<CarrelloGruppo> getCarrelli() {
		return carrelli;
	}
	public void setCarrelli(List<CarrelloGruppo> carrelli) {
		this.carrelli = carrelli;
	}
	

}
