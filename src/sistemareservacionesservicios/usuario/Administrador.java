package sistemareservacionesservicios.usuario;

/**
 *
 * @author joeld
 */
public class Administrador extends Usuario {
    
    public Administrador(String id, String nombre, String telefono) {
        super(id, nombre, telefono);
    }
    
    public void verGanancias() {
        
    }
    
    public void AprobarReserva() {
        
    }
    
    @Override
    public String toString() {
        return String.format("Datos de %s%nNombre: %s%nTelefono: %s%n", 
                getNombre(), getNombre(), getNombre());
    }
}
