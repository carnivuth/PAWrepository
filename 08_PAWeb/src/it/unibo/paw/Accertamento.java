package it.unibo.paw;

public class Accertamento {

	private int id;
	private String codiceAccertamento;
	private String descrizione;
	private String nome;
	public Accertamento() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodiceAccertamento() {
		return codiceAccertamento;
	}
	public void setCodiceAccertamento(String codiceAccertamento) {
		this.codiceAccertamento = codiceAccertamento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
