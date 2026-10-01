/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalogo.gestionclases;

import catalogo.Servicio;
import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class GestionServicio {
    public static ArrayList<Servicio> servicios = new ArrayList<>();
    
    public static Servicio buscarServicio(String id) {
        for(int i = 0; i < servicios.size(); i++) {
          if(servicios.get(i).getId().equals(id)) {
              return servicios.get(i);
          }
        }
        
        return null;
    }
}
