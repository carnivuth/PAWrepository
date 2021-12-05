package beans;

public class Prodotto {
	private int id;
	private int disponibilita;
	private String nome;
	private Double prezzo;
	
	
	public Prodotto(int id,String nome,Double prezzo,int disponibilita) {
		this.id=id;
		this.nome=nome;
		this.prezzo=prezzo;
		this.disponibilita=disponibilita;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
}
