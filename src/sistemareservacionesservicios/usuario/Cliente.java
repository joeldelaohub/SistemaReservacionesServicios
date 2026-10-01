package sistemareservacionesservicios.usuario;

/**
 *
 * @author joeld
 */
public class Cliente extends Usuario {
    
    public Cliente(String id, String nombre, String telefono, Rol rol) {
        super(id, nombre, telefono, rol);
    }
    
    public Cliente(String nombre, String telefono, Rol rol) {
        super(String.format("CLI%02d", contadorUsuarios++), nombre, telefono, rol);
    }
    
    @Override
    public String toString() {
        return String.format("Datos de %s%nNombre: %s%nTelefono: %s%n",getNombre(), getNombre(), getNombre());
    }
}
