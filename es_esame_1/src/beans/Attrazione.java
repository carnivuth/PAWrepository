package beans;

public class Attrazione {
	public Attrazione(int x, int y, String nome, String descrizione) {
		super();
		this.x = x;
		this.y = y;
		this.nome = nome;
		this.descrizione = descrizione;
	}
	private int x;
	private int y;
	private String nome;
	private String descrizione;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Double getUserDistance(AttrazioniUser user) {
		return Math.sqrt(Math.pow(user.getX()-this.x, 2)+Math.pow(user.getY()-this.y, 2));
		
	}
}
