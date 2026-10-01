package sistemareservacionesservicios.usuario;

/**
 *
 * @author joeld
 */
public class Administrador extends Usuario {
    
    public Administrador(String id, String nombre, String telefono, Rol rol) {
        super(id, nombre, telefono, rol);
    }
    
    public Administrador(String nombre, String telefono, Rol rol) {
        super(String.format("ADM%02d", contadorUsuarios++), nombre, telefono, rol);
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
