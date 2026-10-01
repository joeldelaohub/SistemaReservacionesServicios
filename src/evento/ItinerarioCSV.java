package evento;

import evento.gestionclases.GestionEvento;
import static evento.gestionclases.GestionItinerario.itinerarios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

/**
 *
 * @author joeld
 */
public class ItinerarioCSV {
    public static void guardarItinerarios() {
        try(FileWriter rw = new FileWriter("itinerario.csv")) {
            
            rw.write("id;hora Montaje;hora Prueba de Sonido;evento_id\n");
            
            for(Itinerario i: itinerarios) {
                rw.write(i.toCSV() + "\n");
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerItinerario() {
        try(BufferedReader br = new BufferedReader(new FileReader("itinerario.csv"))) {
            String linea = br.readLine();
            
            while((linea = br.readLine()) != null) {
                String[] valores = linea.split(";");
                
                String itinerarioId = valores[0];
                LocalTime horaMontaje = LocalTime.parse(valores[1]);
                LocalTime horaPruebaSonido = LocalTime.parse(valores[2]);
                Evento evento = GestionEvento.buscarEvento(valores[3]);
                
                itinerarios.add(
                        new Itinerario(itinerarioId, horaMontaje,horaPruebaSonido, evento));
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
