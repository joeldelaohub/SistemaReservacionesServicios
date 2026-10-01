package catalogo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import catalogo.gestionclases.GestionServicio;

/**
 *
 * @author joeld
 */
public class ServicioCSV {
    
    
    public static void guardarServicios() {
        try(FileWriter fw = new FileWriter("servicio.csv")) {
            
            fw.write("id;nombre;precio;descripcion\n");
            
            for(Servicio s: GestionServicio.servicios) {
                fw.write(s.toCsv() + "\n");
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerServicios() {
        String linea;
        
        try(BufferedReader br = new BufferedReader(new FileReader("servicio.csv"))) {
            
            linea = br.readLine();
            
            while((linea = br.readLine()) != null) {
                String[] valores = linea.split(";");
                
                GestionServicio.servicios.add(
                        new Servicio(valores[0],
                                valores[1],
                                Double.parseDouble(valores[2]), 
                                valores[3]));
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
