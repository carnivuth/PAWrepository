package it.unibo.paw.percistance.dao.db2;

import it.unibo.paw.model.RistorantePiattoMapping;
import it.unibo.paw.percistance.dao.iterfaces.RistorantePiattoMappingDAO;

public class RistorantePiattoMappingDAODb2 implements RistorantePiattoMappingDAO {
	
	///QUERY STRINGS
	
	//generic table informations
	public static final String TABLE="RistorantePiattoMapping";
	public static final String ID="id";
	public static final String ID_RISTORANTE="idRistorante";
	public static final String ID_PIATTO="idPiatto";
	
	//crud operations
	public static final String CREATE="INSERT INTO "+TABLE+"("
			+ ID+" , "
			+ ID_RISTORANTE+" , "
			+ ID_PIATTO+" ) "
			+ " VALUES("
			+ "(?,?,?)";
	
	public static final String READ="SELECT * FROM "+ TABLE 
			+"WHERE "+ID+" =?" ;
	
	public static final String UPDATE="UPDATE "+TABLE
			+"SET "+ID_PIATTO+" =?" 
			+"SET "+ID_RISTORANTE+" =?"
			+ "WHERE "+ID+ " =?" ;
	
	public static final String DELETE="DELETE FROM "+TABLE+" WHERE "+ID+"=?" ;
	
	
	//ddl operations
	public static final String CREATE_TABLE="CREATE TABLE "
			+TABLE+ "("
			+ ID + " INT NOT NULL PRIMARY KEY, "
			+ ID_PIATTO + "INT NOT NULL , "
			+ ID_RISTORANTE+" INT NOT NULL"
			
			+ "CONSTRAINT MAPPING UNIQUE( "+ID_PIATTO+" , "+ID_RISTORANTE+ " )"
			+ "CONSTRAINT FK_PIATTI FOREIGN KEY ( "+ID_PIATTO+" ) "
			+ "REFERENCES "+PiattoDAODb2.TABLE+" ("+PiattoDAODb2.ID+")"
			+ "CONSTRAINT FK_RISTORANTI FOREIGN KEY ( "+ID_RISTORANTE+" ) "
			+ "REFERENCES "+RistoranteDAODb2.TABLE+"("+RistoranteDAODb2.ID+")"
			
			+ ");";
	
	public static final String DROP_TABLE="DROP TABLE "
			+TABLE+ " ;";


	@Override
	public void create(RistorantePiattoMapping rpm) {
		// TODO Auto-generated method stub

	}

	@Override
	public RistorantePiattoMapping read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RistorantePiattoMapping rpm) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropTable() {
		// TODO Auto-generated method stub

	}

}
