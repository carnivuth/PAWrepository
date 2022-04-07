package it.unibo.paw.percistance.dao.iterfaces;


import it.unibo.paw.model.RistorantePiattoMapping;

public interface RistorantePiattoMappingDAO {
	
	public void create(RistorantePiattoMapping rpm);
	public RistorantePiattoMapping read(int id);
	public void update(RistorantePiattoMapping rpm);
	public void delete(int id);
	
	public void createTable();
	public void dropTable();


}
