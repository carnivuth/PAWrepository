package beans;

public class AttrazioniUser {
	public AttrazioniUser(int x, int y, String username) {
		super();
		this.x = x;
		this.y = y;
		this.username = username;
	}
	private int x;
	private int y;
	private String username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		AttrazioniUser u=(AttrazioniUser)(obj);
		return this.username.equals(u.getUsername());
	}
}
