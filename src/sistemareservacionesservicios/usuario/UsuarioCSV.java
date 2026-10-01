/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservacionesservicios.usuario;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author joeld
 */
public class UsuarioCSV {
    public static void guardarUsuarios() {
        try(FileWriter fw = new FileWriter("usuario.csv")) {
            fw.write("id;nombre;telefono;rol\n");
            
            for(Usuario u: GestionUsuario.usuarios) {
                fw.write(u.toCSV() + "\n");
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerUsuarios() {
        try(BufferedReader br = new BufferedReader(new FileReader("usuario.csv"))) {
            String linea = br.readLine();
            
            while((linea = br.readLine()) != null) {
                String[] valores = linea.split(";");
                
                String usuarioId = valores[0];
                String nombreUsuario = valores[1];
                String telefono = valores[2];
                Rol rol = Rol.valueOf(valores[3]);
                
               switch(rol) {
                   case Rol.CLIENTE:
                       GestionUsuario.usuarios.add(
                        new Cliente(usuarioId,nombreUsuario, telefono, rol));
                        break;
                   case Rol.ADMIN:
                       GestionUsuario.usuarios.add(
                       new Administrador(usuarioId, nombreUsuario, telefono, rol));
                       break;
               }
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
