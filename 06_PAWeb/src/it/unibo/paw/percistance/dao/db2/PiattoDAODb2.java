package it.unibo.paw.percistance.dao.db2;

import it.unibo.paw.model.Piatto;
import it.unibo.paw.percistance.dao.iterfaces.PiattoDAO;

public class PiattoDAODb2 implements PiattoDAO {
	
	///QUERY STRINGS
	
	//generic table informations
	public static final String TABLE="Piatti";
	public static final String ID="id";
	public static final String NOME="nome";
	public static final String TIPOLOGIA="tipologia";
	
	
	//crud operations
	
	public static final String CREATE="INSERT INTO "+TABLE+"("
			+ ID+" , "
			+ NOME+" , "
			+ TIPOLOGIA+" ) "
			+ " VALUES("
			+ "(?,?,?)";
	
	public static final String READ="SELECT * FROM "+ TABLE 
			+"WHERE "+ID+" =?" ;
	
	public static final String UPDATE="UPDATE "+TABLE
			+"SET "+NOME+" =?" 
			+"SET "+TIPOLOGIA+" =?"
			+ "WHERE "+ID+ " =?" ;
	
	public static final String DELETE="DELETE FROM "+TABLE+" WHERE "+ID+"=?" ;
	
	
	//ddl operations
	
	public static final String CREATE_TABLE="CREATE TABLE "
			+TABLE+ "( "
			+ ID + " INT NOT NULL PRIMARY KEY, "
			+ NOME + " VARCHAR(40) NOT NULL UNIQUE, "
			+ TIPOLOGIA + " VARCHAR(40) NOT NULL  "
			+ "CONSTRAINT TIPOLOGIA_VALUE CHECK ("
				+TIPOLOGIA+"='antipasto' ||"
				+TIPOLOGIA+"='primo' ||"
				+TIPOLOGIA+"='secondo' ||"
				+TIPOLOGIA+"='dolce' ||"
			+ ")"
			+ ");";
	
	public static final String DROP_TABLE="DROP TABLE "
			+TABLE+ " ;";

	@Override
	public void create(Piatto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Piatto read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Piatto p) {
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
