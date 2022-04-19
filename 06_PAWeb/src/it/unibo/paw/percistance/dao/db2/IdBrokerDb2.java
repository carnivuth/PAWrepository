package it.unibo.paw.percistance.dao.db2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import it.unibo.paw.percistance.dao.iterfaces.IdBroker;

public class IdBrokerDb2 implements IdBroker {
	private static final String GET_ID="SELECT (NEXTVAL FOR sequenza_id) into new_id";

	@Override
	public int newId() {
		int result=0;
		Statement statement=null;
		Connection connection =Db2DAOFactory.createConnection();
		try {
			
			 statement =connection.createStatement();
			if(statement.execute(GET_ID)) {
				result=statement.getResultSet().getInt("new_id");
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

}
