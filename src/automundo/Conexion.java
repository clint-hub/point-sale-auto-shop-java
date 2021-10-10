/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automundo;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
 //   private final String base = "automundo";
   // private final String user = "root";
   // private final String password = "";
    //private final String url = "jdbc:mysql://localhost:3306/" + base;
    //ONLINE
    private final String base = "raksodev_automundo";
    private final String user = "raksodev_oskar";
    private final String password = "Oskar00914315$";
    private final String url = "jdbc:mysql://mx56.hostgator.mx/" + base;
    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
