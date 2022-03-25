package it.unibo.paw.model;

import java.util.Set;
import java.util.TreeSet;

public class Tavolo {
	private int id;
	private String numero;
	private int capienza;
	private Set<Prenotazione> prenotazioni;
	public Tavolo() {
		prenotazioni=new TreeSet<Prenotazione>();
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCapienza() {
		return capienza;
	}
	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

}
