package sistemareservacionesservicios.usuario;

import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class GestionUsuario {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public static Usuario buscarUsuario(String id) {
        Usuario usuarioEncontrado = null;
        
        
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId().equals(id)) {
                usuarioEncontrado = usuarios.get(i);
            }
        }
        
        return usuarioEncontrado;
    }
}
