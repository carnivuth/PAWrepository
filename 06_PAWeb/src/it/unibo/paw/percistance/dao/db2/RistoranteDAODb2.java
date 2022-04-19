package it.unibo.paw.percistance.dao.db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unibo.paw.model.Ristorante;
import it.unibo.paw.model.RistorantePiattoMapping;
import it.unibo.paw.percistance.dao.iterfaces.IdBroker;
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
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		IdBroker idBr=new IdBrokerDb2();
		try {
			
			 statement =connection.prepareStatement(CREATE);
			 statement.setInt(1, idBr.newId());
			 statement.setString(2,r.getIndirizzo() );
			 statement.setInt(3,r.getRating() );
			 statement.setString(4, r.getNome());
			statement.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		


	}

	@Override
	public Ristorante read(int id) {
		Ristorante result=null;
		ResultSet  r=null;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(READ);
			 statement.setInt(1, id);
			 if(statement.execute()) {
				
				r=statement.getResultSet();
				if(r!=null) {
					
					result=new Ristorante();
					result.setId(r.getInt(ID));
					result.setIndirizzo(r.getString(INDIRIZZO));
					result.setNome(r.getString(NOME));
					result.setRating(r.getInt(RATING));
				}
			 }
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public void update(Ristorante r) {
		
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(UPDATE);
			 statement.setString(1,r.getIndirizzo());
			 statement.setInt(2,r.getRating());
			 statement.setString(3,r.getNome());
			 statement.setInt(4,r.getId());
			if(statement.execute()) {
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

	@Override
	public void delete(int id) {
		
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(DELETE);
			 statement.setInt(1, id);
			 
			if(statement.execute()) {
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	

	}
	@Override
	public void createTable() {
		Statement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.createStatement();
			if(statement.execute(CREATE)) {
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		
		
	}

	@Override
	public void dropTable() {
		Statement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.createStatement();
			if(statement.execute(DROP_TABLE)) {
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		


	}

}
