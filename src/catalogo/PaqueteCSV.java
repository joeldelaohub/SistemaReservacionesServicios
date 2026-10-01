package catalogo;

import catalogo.gestionclases.GestionPaquete;
import catalogo.gestionclases.GestionServicio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author joeld
 */
public class PaqueteCSV {
    public static void guardarPaquetes() {
        try(FileWriter fw = new FileWriter("paquete.csv")) {
            
            fw.write("id;nombre;precio\n");
            
            for(Paquete p: GestionPaquete.paquetes) {
                fw.write(p.toCsv() + "\n");
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerPaquetes() {
       HashMap<String, ArrayList<Servicio>> mapaServicios = new HashMap<>();
       
       try(BufferedReader br = new BufferedReader(new FileReader("paquete_servicios.csv"))) {
           String linea = br.readLine();
           
           while((linea = br.readLine()) != null) {
               String[] valores = linea.split(";");
               
               String paqueteId = valores[0];
               String servicioId = valores[1];
               
               Servicio servicio = GestionServicio.buscarServicio(servicioId);
               
               if(mapaServicios.containsKey(paqueteId)) {
                   mapaServicios.get(paqueteId).add(servicio);
               } else {
                   ArrayList<Servicio> serviciosNuevos = new ArrayList<>();
                   
                   serviciosNuevos.add(servicio);
                   
                   mapaServicios.put(paqueteId, serviciosNuevos);
               }
           }
       }catch(IOException e) {
           System.out.println(e.getMessage());
       }
       
       try(BufferedReader br = new BufferedReader(new FileReader("paquete.csv"))) {
           String linea = br.readLine();
           
           while((linea = br.readLine()) != null) {
               String[] valores = linea.split(";");
               String paqueteId = valores[0];
               String paqueteNombre = valores[1];
               ArrayList<Servicio> paqueteServicios = mapaServicios.get(paqueteId);
               double paquetePrecio = Double.parseDouble(valores[2]);
               
               GestionPaquete.paquetes.add(new Paquete(paqueteId, paqueteNombre, paqueteServicios, paquetePrecio));
           }
           
       }catch(IOException e) {
           System.out.println(e.getMessage());
       }
    }
}
