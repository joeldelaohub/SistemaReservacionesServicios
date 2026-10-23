/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo.gestionclases;

import catalogo.Paquete;
import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class GestionPaquete {
    public static ArrayList<Paquete> paquetes = new ArrayList<>();
    
    public static Paquete buscarPaquete(String id) {
        Paquete paqueteEncontrado = null;
        
        for (int i = 0; i < paquetes.size(); i++) {
            if(paquetes.get(i).getId().equals(id)) {
                paqueteEncontrado = paquetes.get(i);
            }
        }
        
        return paqueteEncontrado;
    }
    
    public static Paquete buscarPaqueteNombre(String nombre) {
        Paquete paqueteEncontrado = null;
        
        for (int i = 0; i < paquetes.size(); i++) {
            if(paquetes.get(i).getNombre().equals(nombre)) {
                paqueteEncontrado = paquetes.get(i);
            }
        }
        
        return paqueteEncontrado;
    }
    
    public static void guardarNumeroID() {
        int mayor = 0;
        
        if(paquetes.isEmpty()) {
            Paquete.contadorPaquete = mayor++;
        } else {
            
            for (int i = 0; i < paquetes.size(); i++) {
            
                String id = paquetes.get(i).getId().substring(3);
                int idNumero = Integer.parseInt(id);

                 if(idNumero > mayor) {
                     mayor = idNumero;
                 }
            }
            
             Paquete.contadorPaquete = ++mayor;
        }
    }
}
