package it.unibo.paw.model;

public enum Tipologia {
	ANTIPASTO("antipasto"),
	PRIMO("primo"),
	SECONDO("secondo"),
	DOLCE("dolce");
	private Tipologia(String value) {
		setValue(value);
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	private String value;
	
}
