package it.unibo.paw.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;



public class DbTable<T> implements CrudInterface<T> {

	private String tableName;
	private Map<String,String> fields;
	private DataSource db;
	public DbTable (String tableName){
		this.tableName=tableName;
		this.db= new DataSource(DataSource.DB2);
	}
	
	@Override
	public void create() {
		
		
		try {
			Connection c =db.getConnection();
			Statement t=c.createStatement();
			
			
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public T read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T item) {
		// TODO Auto-generated method stub
		
	}

	public Map<String,String> getFields() {
		return fields;
	}

	public void setFields(Map<String,String> fields) {
		this.fields = fields;
	}
	public void setFields(List<String> fields,List<String> types) {
		//check list dimensions
		if(fields.size()!=types.size())return;
		//main cycle
		for(int i=0;i<types.size();i++) {
		
			this.fields.put(fields.get(i),types.get(i));
		}
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
