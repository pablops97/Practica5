package Modelo;

/**
 *
 * @author Cala
 */
public class Manga {
    
    int id;
    int codigoUsuario;
    String nombre;
    double precio;
    String descripcion;
    
        public Manga(int id, int codigoUsuario, String nombre, double precio, String descripcion){
        
            this.id=id;
            this.codigoUsuario=codigoUsuario;
            this.nombre=nombre;
            this.precio=precio;
            this.descripcion=descripcion;
            
        }

    public Manga() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre + ", precio=" + precio + ", descripcion=" + descripcion;
    }
    
    
}