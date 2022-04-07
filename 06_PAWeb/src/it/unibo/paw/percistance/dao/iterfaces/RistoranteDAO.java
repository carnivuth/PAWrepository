package it.unibo.paw.percistance.dao.iterfaces;

import it.unibo.paw.model.Ristorante;


public interface RistoranteDAO {
	
	public void create(Ristorante r);
	public Ristorante read(int id);
	public void update(Ristorante r);
	public void delete(int id);
	
	public void createTable();
	public void dropTable();

}
