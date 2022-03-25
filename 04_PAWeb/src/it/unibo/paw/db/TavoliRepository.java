package it.unibo.paw.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


import it.unibo.paw.model.Tavolo;

public class TavoliRepository {
    private DataSource dataSource;
    
    public TavoliRepository(int databaseType) {
        dataSource = new DataSource(databaseType);
    }
    public void dropAndCreateTableTavoli() throws PersistenceException{
	    Connection connection = this.dataSource.getConnection();
	    Statement statement = null;
	    try {
	        statement = connection.createStatement ();
	        try{
	            statement.executeUpdate ("DROP TABLE tavoli");
	        }
	        catch (SQLException e) {
	            // the table does not exist
	        }
	        statement.executeUpdate (
	            "CREATE TABLE tavoli ("	
	            	+ "id INT NOT NULL PRIMARY KEY generated always as identity(start with 1 increment by 1	),"
	                + "numero varchar(40) NOT NULL unique,"
	                + "capienza INT NOT NULL, "      
	            + ") "
	        );
	        statement.close ();
	    }
	    catch (SQLException e) {
	        throw new PersistenceException(e.getMessage());
	    }
	    finally {
	        try {
	            if (statement != null) 
	                statement.close();
	            if (connection!= null)
	                connection.close();
	        }
	        catch (SQLException e) {
	            throw new PersistenceException(e.getMessage());
	        }
	    }
	}
    
    

    
    public void persist(Tavolo t) throws PersistenceException{
        Connection connection = this.dataSource.getConnection();

        if (findByPrimaryKey(t.getId())!=null) 
            throw new PersistenceException("Tavolo exists");
                
        PreparedStatement statement = null; 
        String insert = "insert into tavoli(id,numero, capienza) values (?,?,?)";
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, t.getId());
            statement.setString(2, t.getNumero());
            statement.setInt(3, t.getCapienza());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            }
            catch (SQLException e) {
                throw new PersistenceException(e.getMessage());
            }
        }
    }

    public void delete(Tavolo t) throws PersistenceException{
        Connection connection = this.dataSource.getConnection();

        PreparedStatement statement = null;
        String delete = "delete from tavoli where id = ?";
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, t.getId());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            }
            catch (SQLException e) {
                throw new PersistenceException(e.getMessage());
            }
        }
    }

    public Tavolo findByPrimaryKey(int code) throws PersistenceException {
        Tavolo t= null;
        
        Connection connection = this.dataSource.getConnection();
        PreparedStatement statement = null;
        String query = "select * from tavoli where id=?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, code);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                t = new Tavolo();
                t.setNumero(result.getString("numero"));
                t.setCapienza(result.getInt("capienza"));
                }
        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
                throw new PersistenceException(e.getMessage());
            }
        }
        return t;
    }
    
    public List<Tavolo> findAll() throws PersistenceException {
        List<Tavolo> tavoli = null;
        Tavolo tavolo = null;
        Connection connection = this.dataSource.getConnection();
        PreparedStatement statement = null;
        String query = "select * from tavoli";
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
            	tavoli = new LinkedList<Tavolo>();
            	tavolo = new Tavolo();
            	tavolo.setNumero(result.getString("numero"));
            	tavolo.setId(result.getInt("id"));
            	tavolo.setCapienza(result.getInt("capienza"));
               tavoli.add(tavolo);
            }
            while(result.next()) {
            	tavoli = new LinkedList<Tavolo>();
            	tavolo = new Tavolo();
            	tavolo.setId(result.getInt("id"));
            	tavolo.setNumero(result.getString("numero"));
            	tavolo.setCapienza(result.getInt("capienza"));
               tavoli.add(tavolo);
            }
        }
        catch (SQLException e) {
            throw new PersistenceException(e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
                throw new PersistenceException(e.getMessage());
            }
        }
        return tavoli;
    }   

    
    
}
