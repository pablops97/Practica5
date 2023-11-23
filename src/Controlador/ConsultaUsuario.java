/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ConoMaster
 */
public class ConsultaUsuario {

    public ConsultaUsuario(Conexion con) {

    }

    public static Usuario getUsuario(String nombre, String contrasenia) throws SQLException {

        Connection conexion = Conexion.getConnection();
        Statement st = conexion.createStatement();

        ResultSet rs = st.executeQuery("Select IDUSUARIO, USUARIO, CONTRASENIA, FECHAINGRESO, FOTO from USUARIO where usuario = '" + nombre + "'" + " AND contrasenia = '" + contrasenia + "'");

        return recorrer(rs);
    }

    public static Usuario recorrer(ResultSet rs) throws SQLException {
        Usuario user = null;
        while (rs.next()) {

            int id = rs.getInt("IDUSUARIO");
            String nombreUsuario = rs.getString("USUARIO");
            String pass = rs.getString("CONTRASENIA");
            Date fecha = rs.getDate("FECHAINGRESO");
            String foto = rs.getString("FOTO");

            user = new Usuario(id, nombreUsuario, pass, fecha, foto);

            System.out.println("Nombre de usuario: " + nombreUsuario + " " + pass);
        }
        return user;
    }

    public static ArrayList<Usuario> listaUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Connection conexion = Conexion.getConnection();
        Statement st = conexion.createStatement();

        ResultSet rs = st.executeQuery("Select IDUSUARIO, USUARIO, CONTRASENIA, FECHAINGRESO, FOTO from USUARIO");
        Usuario user;
        while (rs.next()) {

            int id = rs.getInt("IDUSUARIO");
            String nombreUsuario = rs.getString("USUARIO");
            String pass = rs.getString("CONTRASENIA");
            Date fecha = rs.getDate("FECHAINGRESO");
            String foto = rs.getString("FOTO");
            user = new Usuario(id, nombreUsuario, pass, fecha, foto);
            listaUsuarios.add(user);
        }
        return listaUsuarios;

    }


}
