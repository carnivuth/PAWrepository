package it.unibo.paw.percistance.dao.iterfaces;

import it.unibo.paw.model.Piatto;

public interface PiattoDAO {
	public void create(Piatto p);
	public Piatto read(int id);
	public void update(Piatto p);
	public void delete(int id);
	
	public void createTable();
	public void dropTable();

}
