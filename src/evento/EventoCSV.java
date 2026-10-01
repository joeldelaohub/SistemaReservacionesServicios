package evento;

import evento.gestionclases.GestionEvento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author joeld
 */
public class EventoCSV {
    public static void guardarEventos() {
        try(FileWriter fw = new FileWriter("evento.csv")) {
            
            fw.write("id;fecha;duracion;ubicacion;tipo;hora\n");
            
            for(Evento e: GestionEvento.eventos) {
                fw.write(e.toCSV() + "\n");
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerEventos() {
        String linea;
        
        try(BufferedReader br = new BufferedReader(new FileReader("evento.csv"))) {
            
            linea = br.readLine();
            
            while((linea = br.readLine()) != null) {
                String valores[] = linea.split(";");
                
                String eventoId = valores[0];
                LocalDate fechaEvento = LocalDate.parse(valores[1]);
                int duracionEvento = Integer.parseInt(valores[2]);
                String ubicacionEvento = valores[3];
                String tipoEvento = valores[4];
                LocalTime horaEvento = LocalTime.parse(valores[5]);
                
                GestionEvento.eventos.add(new Evento(eventoId, fechaEvento,
                            duracionEvento, ubicacionEvento, tipoEvento,
                            horaEvento));
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
