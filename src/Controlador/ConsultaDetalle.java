/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion;
import Modelo.Manga;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ConoMaster
 */
public class ConsultaDetalle {
    
    
    private static ResultSet rs;
    public ConsultaDetalle(){
 
    }
    
    //estaba volviendo a iniciarlizar rs en cada metodo entonces siempre empezaba por el principio
    public static void iniciarResultSet(Usuario user){
        ConsultaDetalle.rs = getResultSet(user);
    }
    
    public static boolean isLast() throws SQLException
    {
        if(rs.isLast())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isFirst() throws SQLException
    {
        if(rs.isFirst())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static Manga inicial(Usuario user) throws SQLException{
        
        Manga m = new Manga();

            rs.first();
            m.setId(rs.getInt("ID"));
            m.setCodigoUsuario(rs.getInt("CODIGOUSUARIO"));
            m.setNombre(rs.getString("NOMBRE"));
            m.setPrecio(rs.getDouble("PRECIO"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            
        
        return m;
    }
    
    public static Manga siguiente(Usuario user) throws SQLException{
        
        Manga m = new Manga();
        
        
        if (!rs.isLast()) {
            rs.next();
            m.setId(rs.getInt("ID"));
            m.setCodigoUsuario(rs.getInt("CODIGOUSUARIO"));
            m.setNombre(rs.getString("NOMBRE"));
            m.setPrecio(rs.getDouble("PRECIO"));
            m.setDescripcion(rs.getString("DESCRIPCION"));  
        }

        return m;
    }
    
    public static Manga atras(Usuario user) throws SQLException{
        
        Manga m = new Manga();
        
        
        if (!rs.isFirst()) {
            rs.previous();
            m.setId(rs.getInt("ID"));
            m.setCodigoUsuario(rs.getInt("CODIGOUSUARIO"));
            m.setNombre(rs.getString("NOMBRE"));
            m.setPrecio(rs.getDouble("PRECIO"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            
        }

        return m;
    }
    
    public static Manga ultimo(Usuario user) throws SQLException{
        Manga m = new Manga();
        ResultSet rs = getResultSet(user);
        
        if(!rs.isAfterLast()){
            rs.last();
            m.setId(rs.getInt("ID"));
            m.setCodigoUsuario(rs.getInt("CODIGOUSUARIO"));
            m.setNombre(rs.getString("NOMBRE"));
            m.setPrecio(rs.getDouble("PRECIO"));
            m.setDescripcion(rs.getString("DESCRIPCION"));
            //rs.updateRow();
            rs.next();
            return m;
        }else{
            return null;
        }
        
    }
     public static void ActualizarManga(Manga m) throws SQLException{
        
        try {
            // Obtener la conexión
            Connection connection = Conexion.getConnection();

            // Crear el Statement
            Statement statement = connection.createStatement();

            // Consulta SQL para actualizar la descripción del manga
            String sql = "UPDATE Manga SET descripcion = '" + m.getDescripcion() + "' WHERE Id =" + m.getId();
            System.out.println(""+m.getId());
            // Ejecutar la consulta de actualización
            int filasAfectadas = statement.executeUpdate(sql);

            // Verificar si la actualización fue exitosa
            if (filasAfectadas > 0) {
                System.out.println("Actualización exitosa");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
       
            }
        }
    
    
    public static ResultSet getResultSet(Usuario user){
        
        try {
            Connection conexion;
            conexion = Conexion.getConnection();
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs;
            rs = st.executeQuery("SELECT ID, CODIGOUSUARIO, NOMBRE, PRECIO, DESCRIPCION FROM MANGA M INNER JOIN USUARIO U ON M.CODIGOUSUARIO = U.IDUSUARIO WHERE U.USUARIO = '"+user.getNombre()+ "' AND U.CONTRASENIA = '"+user.getContrasenia()+"'");
            
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            
        };
        
        return null;  
    }
 
    public static ArrayList<Manga> listaMangas(Usuario user) throws SQLException {
        ResultSet rs = getResultSet(user);  // Obtener el ResultSet desde la función anterior
        ArrayList<Manga> listaMangas = new ArrayList<>();

        if (rs != null) {
            while (rs.next()) {
                Manga m = new Manga();
                m.setId(rs.getInt("ID"));
                m.setCodigoUsuario(rs.getInt("CODIGOUSUARIO"));
                m.setNombre(rs.getString("NOMBRE"));
                m.setPrecio(rs.getDouble("PRECIO"));
                m.setDescripcion(rs.getString("DESCRIPCION"));
                listaMangas.add(m);
            }
        }

        return listaMangas;
    }
}
