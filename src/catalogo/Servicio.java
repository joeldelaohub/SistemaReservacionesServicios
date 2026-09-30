package catalogo;

/**
 *
 * @author joeld
 */
public class Servicio {
    private final String id;
    private String nombre;
    private double precio;
    private String descripcion;
    private static int contadorServicios = 0;
    
    public Servicio(String nombre, double precio, String descripcion) {
        this.id = String.format("SE%02d", contadorServicios++);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
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
        return String.format("id: %s%nNombre: %s%nPrecio: %.2f%nDescripcion: %s%n",id, nombre, precio, descripcion);
    }
}
