/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evento.gestionclases;

import evento.Evento;
import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class GestionEvento {
    public static ArrayList<Evento> eventos = new ArrayList<>();
        
    public static Evento buscarEvento(String id) {
        
         Evento eventoEncontrado = null;
        
        for(int i = 0; i < eventos.size(); i++) {
          if(eventos.get(i).getId().equals(id)) {
              eventoEncontrado = eventos.get(i);
          }
        }
        
        return eventoEncontrado;
    }
}
