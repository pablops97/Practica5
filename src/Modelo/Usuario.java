package Modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author David
 */
public class Usuario {
    int idUsuario;
    String nombre;
    String contrasenia;
    Calendar fechaIngreso;
    String foto;
    
    public Usuario(int idUsuario, String nombre, String contrasenia)
    {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.fechaIngreso = new GregorianCalendar();
    }

    public Usuario() {
        
    }

    public Usuario(int id, String nombreUsuario, String pass, java.sql.Date fecha, String foto) {
        
        this.idUsuario = id;
        this.nombre = nombreUsuario;
        this.contrasenia = pass;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        this.fechaIngreso = calendar;
        this.foto = foto;
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

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fecha) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = formatoFecha.parse(fecha);

            // Crear un objeto Calendar y establecer la fecha
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            this.fechaIngreso = calendar;
            System.out.println("Fecha en formato GregorianCalendar: " + calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", fechaIngreso=" + fechaIngreso + ", foto=" + foto + '}' + "\n";
    }
    
    
}