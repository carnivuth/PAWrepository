package it.unibo.paw.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import it.unibo.paw.model.NumeroTavolo;
import it.unibo.paw.model.Prenotazione;

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
	                + "idTavolo INT NOT NULL, "
	                + "constraint tavolo UNIQUE (idTavolo,data),"
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

        if (t.getId()!=0 && findByPrimaryKey(t.getId())!=null) 
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
        String delete = "delete from prenotazioni where code = ?";
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
        String query = "select * from prenotazioni";
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
    public boolean RichiestaPrenotazione(String cognome, Date data,int numeroPersone,String cellulare) {
    	
    	NumeroTavolo nt=null;
    	Prenotazione p=new Prenotazione();
    	if((nt=DisponibilitaTavolo(data, numeroPersone))!=null) {
    		p.setCellulare(cellulare);
    		p.setCognome(cognome);
    		p.setData(data);
    		p.setIdTavolo(nt.getIdTavolo());
    		p.setNumeroPersone(numeroPersone);
    		try {
				persist(p);
			} catch (PersistenceException e1) {
				e1.printStackTrace();
			}
    		return true;
    		
    		
    	}
    	return false;
    }
    public NumeroTavolo DisponibilitaTavolo(Date data,int numeroPersone) {
    	PreparedStatement statement = null;
    	Connection connection=null;
    	ResultSet result=null;
    	NumeroTavolo nt=null;
    	try {
			connection = this.dataSource.getConnection();
			String query="SELECT id, numero FROM TAVOLI WHERE CAPIENZA>= ?AND ID NOT IN ("
					+ "SELECT IDTAVOLO FROM PRENOTAZIONI WHERE DATA=?) ";
			statement=connection.prepareStatement(query);
			statement.setInt(1, numeroPersone);
			statement.setDate(2, data);
			
			if(statement.execute()) {
				result=statement.getResultSet();
				if(result.next()) {
					nt=new NumeroTavolo();
					nt.setIdTavolo(result.getInt("id"));
					nt.setNumeroTavolo(result.getString("numero"));
					return nt;
				}
			}
			
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
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
    	return null;
        
    	
    	
    	
    }

    
    
}
