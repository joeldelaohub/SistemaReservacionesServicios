package sistemareservacionesservicios.usuario;

public class Usuario {
    private final String id;
    private String nombre;
    private String telefono;
    private Rol rol;
    protected static int contadorUsuarios = 0;
    
    public Usuario(String id, String nombre, String telefono, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.rol = rol;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String toCSV() {
        return String.join(";", id, nombre, telefono, String.valueOf(rol));
    }
}
