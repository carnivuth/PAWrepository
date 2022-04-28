package it.unibo.paw;

import java.util.HashSet;
import java.util.Set;

public class TipoAccertamento {
	private int id;
	private String codiceTipoAccertamento;
	private String descrizione;
	private Set<Accertamento> accertamenti;
	private Set<Ospedale> ospedali;
	
	public TipoAccertamento() {
		accertamenti=new HashSet<Accertamento>();
		ospedali=new HashSet<Ospedale>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodiceTipoAccertamento() {
		return codiceTipoAccertamento;
	}
	public void setCodiceTipoAccertamento(String codiceTipoAccertamento) {
		this.codiceTipoAccertamento = codiceTipoAccertamento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Set<Accertamento> getAccertamenti() {
		return accertamenti;
	}
	public void setAccertamenti(Set<Accertamento> accertamenti) {
		this.accertamenti = accertamenti;
	}
	public Set<Ospedale> getOspedali() {
		return ospedali;
	}
	public void setOspedali(Set<Ospedale> ospedali) {
		this.ospedali = ospedali;
	}

}
