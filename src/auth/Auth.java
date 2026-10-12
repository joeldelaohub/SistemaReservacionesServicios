/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;


import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import sistemareservacionesservicios.usuario.GestionUsuario;
import sistemareservacionesservicios.usuario.Usuario;
import sistemareservacionesservicios.usuario.UsuarioCSV;

/**
 *
 * @author joeld
 */
public class Auth {
    public static Usuario usuarioLogueado = null;
    
    public static Usuario iniciarSesion(String nombre) {
        Usuario usuarioEncontrado = GestionUsuario.buscarUsuarioNombre(nombre);
        
        usuarioLogueado = usuarioEncontrado;
        
        return usuarioEncontrado;
    }
    
    public static boolean registrar(Usuario usuario, JPanel panel) {
        Usuario usuarioRegistrado = GestionUsuario.buscarUsuarioId(usuario.getId());
        boolean siEstaRegistrado = false;
        
        if(usuarioRegistrado != null) {
            JOptionPane.showMessageDialog(panel, "ya estas registrado, inicia sesion", "Aviso",WARNING_MESSAGE);
            siEstaRegistrado = true;
        } else {
            JOptionPane.showMessageDialog(panel, "Registro Exitoso!");
            GestionUsuario.usuarios.add(usuario);
            siEstaRegistrado = false;
        }
        
        UsuarioCSV.guardarUsuarios();
        return siEstaRegistrado;
    }
}
