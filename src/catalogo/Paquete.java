package catalogo;

import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class Paquete {
    private final String id;
    private String nombre;
    public static ArrayList<Servicio> listaServicios;
    
    public Paquete(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    
    public double calcularPrecio() {
        double precio = 0.0;
        
        return precio;
    }
}
