package sistemareservacionesservicios.usuario;

import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class GestionUsuario {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public static Usuario buscarUsuarioId(String id) {
        Usuario usuarioEncontrado = null;

        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId().equals(id)) {
                usuarioEncontrado = usuarios.get(i);
            }
        }
        
        return usuarioEncontrado;
    }
    
    public static Usuario buscarUsuarioNombre(String nombre) {
        Usuario usuarioEncontrado = null;

        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getNombre().equals(nombre)) {
                usuarioEncontrado = usuarios.get(i);
            }
        }
        
        return usuarioEncontrado;
    }
}
