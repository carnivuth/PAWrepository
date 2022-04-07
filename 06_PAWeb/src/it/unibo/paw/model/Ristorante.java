package it.unibo.paw.model;

import java.util.ArrayList;
import java.util.List;

public class Ristorante {
	
	private int id;
	private String nome;
	private String indirizzo;
	private int rating;
	private List<Piatto> piatti;
	
	public Ristorante() {
		
		piatti=new ArrayList<Piatto>();
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		
		if(rating>=1 && rating<=5)this.rating = rating;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Piatto> getPiatti() {
		return piatti;
	}
	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
