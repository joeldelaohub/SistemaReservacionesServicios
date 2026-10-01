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
}
