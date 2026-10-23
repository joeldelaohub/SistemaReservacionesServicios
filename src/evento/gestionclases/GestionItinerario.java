package evento.gestionclases;

import evento.Itinerario;
import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class GestionItinerario {
    public static ArrayList<Itinerario> itinerarios = new ArrayList<>();
    
    public static void guardarNumeroID() {
        int mayor = 0;
        
        if(itinerarios.isEmpty()) {
            Itinerario.contadorItinerarios = mayor++;
        } else {
            
            for (int i = 0; i < itinerarios.size(); i++) {
            
                String id = itinerarios.get(i).getId().substring(2);
                int idNumero = Integer.parseInt(id);

                 if(idNumero > mayor) {
                     mayor = idNumero;
                 }
            }
            
             Itinerario.contadorItinerarios = ++mayor;
        }
    }
}
