package beans;

import java.util.ArrayList;
import java.util.List;

public class Attrazioni {
	
	private List<Attrazione> attrazioni;
	public Attrazioni() {
	this.attrazioni=new ArrayList<Attrazione>();
	this.attrazioni.add(new Attrazione(2, 4, "a1", "a1desc"));
	this.attrazioni.add(new Attrazione(2, 4, "a2", "a1desc"));
	this.attrazioni.add(new Attrazione(2, 4, "a3", "a1desc"));
	this.attrazioni.add(new Attrazione(2, 4, "a4", "a1desc"));
	this.attrazioni.add(new Attrazione(2, 4, "a5", "a1desc"));
	}
	public List<Attrazione> getAttrazioni() {
		return attrazioni;
	}
	public void setAttrazioni(List<Attrazione> attrazioni) {
		this.attrazioni = attrazioni;
	}
	
	
}
