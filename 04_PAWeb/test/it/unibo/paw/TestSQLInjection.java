package it.unibo.paw;

import java.sql.*;
import java.util.*;
import java.io.*;
 
public class TestSQLInjection {
    /*
     * Per provare l'SQL injection inserire come password: a' OR 'b'='b
     */
    public static void main(String[] args) {
        Connection con = null;
        String dbUser;
        String dbPassword;
        try {
            @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
            
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            String url = "jdbc:db2://diva.deis.unibo.it:50000/tw_stud";
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            //lettura credenziali
            
            BufferedReader cr = new BufferedReader(new FileReader(new File("resources/dbcredentials.txt")));
            dbUser = cr.readLine();
           
            dbPassword = cr.readLine();
            cr.close();
            
            // Sostituire nome utente e password con quelli in uso sul proprio sistema
            // N.B.: memorizzare staticamnte dati di accesso in un software è una
            // pratica sconsigliabile.
            con = DriverManager.getConnection(url, dbUser, dbPassword);
          
            Statement stmt = con.createStatement();
            
            System.out.println("Inserire il nome utente: ");
            String username = scanner.next();
            
            System.out.println("Inserire la password");
            String password = br.readLine();
            
            System.out.println(String.format("Provo ad autenticare %s con password %s", username, password));
            
            // Codice vulnerabile
            // INIZIO VULNERABILE -----------------------------------------------------------------------------
            String query = "SELECT * FROM UTENTI WHERE ID = '"+username+"' AND PASSWORD = '"+password+"'";
            System.out.println("Query da eseguire: " + query);
            
            ResultSet rs = stmt.executeQuery(query);
            // FINE VULNERABILE -------------------------------------------------------------------------------
            
            // Codice non vulnerabile
            // INIZIO NON VULNERABILE --------------------------------------------------------------------------
            //PreparedStatement pstmt = con.prepareStatement("SELECT * FROM UTENTI WHERE ID = ? AND PASSWORD = ?");
            //pstmt.setString(1, username);
            //pstmt.setString(2, password);
            //ResultSet rs = pstmt.executeQuery();
            // FINE NON VULNERABILE -----------------------------------------------------------------------------
            
            
            System.out.println("\n---------------------------");
            if (rs.next()) {
                System.out.println("Utente autenticato!");
            } else {
                System.out.println("Utente non autorizzato");
            }
            rs.close();
            stmt.close();
            //pstmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    
                }
            }
        }
    }
}
