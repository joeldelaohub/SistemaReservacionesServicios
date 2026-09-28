package sistemareservacionesservicios.usuario;

/**
 *
 * @author joeld
 */
public class Cliente extends Usuario {
    
    public Cliente(String id, String nombre, String telefono) {
        super(id, nombre, telefono);
    }
    
    @Override
    public String toString() {
        return String.format("Datos de %s%nNombre: %s%nTelefono: %s%n",getNombre(), getNombre(), getNombre());
    }
}
