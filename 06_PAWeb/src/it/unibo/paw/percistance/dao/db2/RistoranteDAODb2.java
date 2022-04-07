package it.unibo.paw.percistance.dao.db2;

import it.unibo.paw.model.Ristorante;
import it.unibo.paw.percistance.dao.iterfaces.RistoranteDAO;

public class RistoranteDAODb2 implements RistoranteDAO {
	
	///QUERY STRINGS

	//generic table informations
	
	public static final String TABLE="Ristoranti";
	public static final String ID="id";
	public static final String INDIRIZZO="indirizzo";
	public static final String NOME="nome";
	public static final String RATING="rating";


	//crud operations
	
	public static final String CREATE="INSERT INTO "+TABLE+"("
			+ ID+" , "
			+ INDIRIZZO+" , "
			+ RATING+" , "
			+ NOME+" ) "
			+ " VALUES("
			+ "(?,?,?,?)";
	
	public static final String READ="SELECT * FROM "+ TABLE 
			+"WHERE "+ID+" =?" ;
	
	public static final String UPDATE="UPDATE "+TABLE
			+"SET "+INDIRIZZO+" =?" 
			+"SET "+NOME+" =?"
			+"SET "+RATING+" =?"
			+ "WHERE "+ID+ " =?" ;
	
	public static final String DELETE="DELETE FROM "+TABLE+" WHERE "+ID+"=?" ;
	
	
	//ddl operations
	
	public static final String CREATE_TABLE="CREATE TABLE "
			+TABLE+ "("
			+ ID + " INT NOT NULL PRIMARY KEY, "
			+ NOME + " NOME VARCHAR(40) NOT NULL UNIQUE, "
			+ INDIRIZZO+" VARCHAR(40) NOT NULL"
			+ RATING+" INT NOT NULL"
			+ "CONSTRAINT RATING_VALUE CHECK( "+RATING+">=1 && "+RATING+"<=5 )"
			+ ");";
	
	public static final String DROP_TABLE="DROP TABLE "
			+TABLE+ " ;";


	@Override
	public void create(Ristorante r) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ristorante read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Ristorante r) {
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
