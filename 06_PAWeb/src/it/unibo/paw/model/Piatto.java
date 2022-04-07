package it.unibo.paw.model;



public class Piatto {
	
	private int id;
	private String nome;
	private Tipologia tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Tipologia getTipo() {
		return tipo;
	}

	public void setTipo(Tipologia tipo) {
		this.tipo = tipo;
	}
	

}
