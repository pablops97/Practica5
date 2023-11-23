/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;
import Controlador.ConsultaDetalle;
import Controlador.ConsultaUsuario;
import Modelo.Manga;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ConoMaster
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        new Conexion();
        
        Usuario u = ConsultaUsuario.getUsuario("bob_jones", "pass1234");
        ArrayList<Manga> mangas = ConsultaDetalle.listaMangas(u);
        System.out.println(mangas);
    }
    
}
