package it.unibo.paw.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import it.unibo.paw.model.Prenotazione;
import it.unibo.paw.model.Tavolo;

public class PrenotazioneRepository {
    private DataSource dataSource;
    
    public PrenotazioneRepository(int databaseType) {
        dataSource = new DataSource(databaseType);
    }
 
    public void dropAndCreateTablePrenotazioni() throws PersistenceException{
	    Connection connection = this.dataSource.getConnection();
	    Statement statement = null;
	    try {
	        statement = connection.createStatement ();
	        try{
	            statement.executeUpdate ("DROP TABLE prenotazioni");
	        }
	        catch (SQLException e) {
	            // the table does not exist
	        }
	        statement.executeUpdate (
	            "CREATE TABLE prenotazioni ("
	            	+ "id INT NOT NULL PRIMARY KEY generated always as identity(start with 1 increment by 1	),"
	                + "cognome INT NOT NULL UNIQUE,"
	                + " cellulare CHAR(8), " 
	                + "numeroPersone INT NOT NULL, "
	                + "data DATE  NOT NULL,"
	                + "idTavolo INT "
	                + "constraint tavolo UNIQUE (idTavolo,data)"
	                +"constraint id_prenotazione UNIQUE (Cognome,data)"
	                
	            
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

    
    public void persist(Prenotazione t) throws PersistenceException{
        Connection connection = this.dataSource.getConnection();

        if (findByPrimaryKey(t.getId())!=null) 
            throw new PersistenceException("Prenotazione exists");
                
        PreparedStatement statement = null; 
        String insert = "insert into prenotazioni(cognome, cellulare, numeroPersone, data,idTavolo) values (?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, t.getCognome());
            statement.setString(2, t.getCellulare());
            statement.setInt(3, t.getNumeroPersone());
            statement.setDate(4, new java.sql.Date(t.getData().getTime()));
            statement.setInt(5, t.getIdTavolo());
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

    public void delete(Prenotazione p) throws PersistenceException{
        Connection connection = this.dataSource.getConnection();

        PreparedStatement statement = null;
        String delete = "delete from students where code = ?";
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, p.getId());
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

    public Prenotazione findByPrimaryKey(int code) throws PersistenceException {
        Prenotazione p= null;
        
        Connection connection = this.dataSource.getConnection();
        PreparedStatement statement = null;
        String query = "select * from Prenotazioni where code=?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, code);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                p = new Prenotazione();
                p.setId(result.getInt("id"));
                p.setNumeroPersone(result.getInt("numeroPersone"));
                p.setCognome(result.getString("cognome"));
                p.setCellulare(result.getString("cellulare"));
                p.setData(result.getDate("data"));
                p.setIdTavolo(result.getInt("idTavolo"));
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
        return p;
    }   
    
    public List<Prenotazione> findAll() throws PersistenceException {
        List<Prenotazione> prenotazioni = null;
        Prenotazione p= null;
        Connection connection = this.dataSource.getConnection();
        PreparedStatement statement = null;
        String query = "select * from students";
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                prenotazioni = new LinkedList<Prenotazione>();
                p = new Prenotazione();
                p.setId(result.getInt("id"));
                p.setNumeroPersone(result.getInt("numeroPersone"));
                p.setCognome(result.getString("cognome"));
                p.setCellulare(result.getString("cellulare"));
                p.setData(result.getDate("data"));
                p.setIdTavolo(result.getInt("idTavolo"));
                prenotazioni.add(p);
                }
            while(result.next()) {
            	p = new Prenotazione();
                p.setId(result.getInt("id"));
                p.setNumeroPersone(result.getInt("numeroPersone"));
                p.setCognome(result.getString("cognome"));
                p.setCellulare(result.getString("cellulare"));
                p.setData(result.getDate("data"));
                p.setIdTavolo(result.getInt("idTavolo"));
                prenotazioni.add(p);
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
        return prenotazioni;
    }   

    
    
}
