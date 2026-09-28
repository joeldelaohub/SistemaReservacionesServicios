package catalogo;

/**
 *
 * @author joeld
 */
public class Servicio {
    private String nombre;
    private double precio;
    private String descripcion;
    
    public Servicio(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return String.format("Nombre: %s%nPrecio: %.2f%nDescripcion: %s%n", nombre, precio, descripcion);
    }
}
