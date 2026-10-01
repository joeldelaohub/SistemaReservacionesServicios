package reserva;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import reserva.gestionclases.GestionFactura;

/**
 *
 * @author joeld
 */
public class FacturaCSV {
    public static void guardarFacturas() {
        try(FileWriter fw = new FileWriter("factura.csv")) {
            fw.write("id;reserva_id;monto total;saldo restante;saldo anticipado;reembolso\n");
            
            for(Factura f: GestionFactura.facturas) {
                fw.write(f.toCSV());
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerFacturas() {
        try(BufferedReader br = new BufferedReader(new FileReader("factura.csv"))) {
            
            String linea = br.readLine();
            
            while((linea = br.readLine()) != null) {
                String[] valores = linea.split(";");
                
                String facturaId = valores[0];
                Reserva reserva = GestorReserva.buscarReserva(valores[1]);
                double montoTotal = Double.parseDouble(valores[2]);
                double saldoAnticipado = Double.parseDouble(valores[3]);
                
                GestionFactura.facturas.add(new Factura(facturaId, reserva, montoTotal, saldoAnticipado));
            }
            
        }catch(IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
