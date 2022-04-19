package it.unibo.paw.percistance.dao.db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unibo.paw.model.Piatto;
import it.unibo.paw.model.Tipologia;
import it.unibo.paw.percistance.dao.iterfaces.IdBroker;
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
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		IdBroker idBr=new IdBrokerDb2();
		try {
			
			 statement =connection.prepareStatement(CREATE);
			 statement.setInt(1, idBr.newId());
			 statement.setString(2,p.getNome() );
			 statement.setString(3, p.getTipo().getValue());
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
	public Piatto read(int id) {
		Piatto result=null;
		ResultSet  r=null;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(READ);
			 statement.setInt(1, id);
			 if(statement.execute()) {
				
				r=statement.getResultSet();
				if(r!=null) {
					
					result=new Piatto();
					result.setId(r.getInt(ID));
					result.setNome(r.getString(NOME));
					result.setTipo(Tipologia.valueOf(r.getString(TIPOLOGIA)));
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
	public void update(Piatto p) {
		
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(UPDATE);
			 statement.setString(1,p.getNome());
			 statement.setString(2,p.getTipo().getValue());
			 statement.setInt(3,p.getId());
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
