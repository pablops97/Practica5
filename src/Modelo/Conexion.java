package Modelo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private Connection miConexion;
    
    public Conexion() throws SQLException{
        
    }
    
    public static Connection getConnection() throws SQLException {
        Connection miConexion = DriverManager.getConnection("jdbc:derby://localhost:1527/Examen","examen","examen");
    return miConexion;
  } 

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ignored) {
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException ignored) {
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ignored) {
        }
    }
   
    
}