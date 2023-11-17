package Modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author David
 */
public class Usuario {
    int idUsuario;
    String nombre;
    String contrasenia;
    GregorianCalendar fechaIngreso;
    
    public Usuario(int idUsuario, String nombre, String contrasenia)
    {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.fechaIngreso = new GregorianCalendar();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public GregorianCalendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(GregorianCalendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
}