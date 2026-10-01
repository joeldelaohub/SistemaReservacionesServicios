package catalogo;

import catalogo.gestionclases.GestionPaquete;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author joeld
 */
public class PaqueteServicioCSV {
    public static void guardarPaqueteServicio() {
        try(FileWriter fw = new FileWriter("paquete_servicios.csv")) {
            
            fw.write("paquete_id;servicio_id\n");
            
            for (int i = 0; i < GestionPaquete.paquetes.size(); i++) {
                for(int j = 0; j < GestionPaquete.paquetes.get(i).getListaServicios().size(); j++) {
                    
                    fw.write(String.join(";", GestionPaquete.paquetes.get(i).getId(),
                        GestionPaquete.paquetes.get(i).getListaServicios().get(j).getId()
                    ) + "\n");
                    
                }
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
