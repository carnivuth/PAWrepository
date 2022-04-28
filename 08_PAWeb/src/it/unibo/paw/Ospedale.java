package it.unibo.paw;

import java.util.HashSet;
import java.util.Set;

public class Ospedale {
	public Ospedale() {
		tipiAccertamento=new HashSet<TipoAccertamento>();
	}
	private int id;
	private String codiceOspedale;
	private String nome;
	private String citta;
	private String indirizzo;
	private Set<TipoAccertamento> tipiAccertamento;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodiceOspedale() {
		return codiceOspedale;
	}
	public void setCodiceOspedale(String codiceOspedale) {
		this.codiceOspedale = codiceOspedale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public Set<TipoAccertamento> getTipiAccertamento() {
		return tipiAccertamento;
	}
	public void setTipiAccertamento(Set<TipoAccertamento> tipiAccertamento) {
		this.tipiAccertamento = tipiAccertamento;
	}
	

}
