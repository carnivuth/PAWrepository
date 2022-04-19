package it.unibo.paw.percistance.dao.db2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import it.unibo.paw.model.RistorantePiattoMapping;
import it.unibo.paw.percistance.dao.iterfaces.IdBroker;
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
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		IdBroker idBr=new IdBrokerDb2();
		try {
			
			 statement =connection.prepareStatement(CREATE);
			 statement.setInt(1, idBr.newId());
			 statement.setInt(2,rpm.getIdRistorante() );
			 statement.setInt(3, rpm.getIdPiatto());
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
	public RistorantePiattoMapping read(int id) {
		RistorantePiattoMapping result=null;
		ResultSet  r=null;
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(READ);
			 statement.setInt(1, id);
			 if(statement.execute()) {
				
				r=statement.getResultSet();
				if(r!=null) {
					
					result=new RistorantePiattoMapping();
					result.setId(r.getInt(ID));
					result.setIdPiatto(r.getInt(ID_PIATTO));
					result.setIdRistorante(r.getInt(ID_RISTORANTE));
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
	public void update(RistorantePiattoMapping rpm) {
		
		PreparedStatement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.prepareStatement(UPDATE);
			 statement.setInt(1,rpm.getIdRistorante());
			 statement.setInt(2,rpm.getIdPiatto());
			 statement.setInt(3,rpm.getId());
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
