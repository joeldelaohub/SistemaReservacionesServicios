package reserva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import sistemareservacionesservicios.usuario.Cliente;
import sistemareservacionesservicios.usuario.GestionUsuario;
import evento.gestionclases.GestionEvento;
import evento.Evento;
import catalogo.Paquete;
import catalogo.gestionclases.GestionPaquete;
import estados.Estado;
import java.time.LocalDateTime;
/**
 *
 * @author joeld
 */
public class ReservaCSV {
    public static void guardarReserva() {
        try(FileWriter fw = new FileWriter("reserva.csv")) {
            
            fw.write("id;cliente_id;evento_id;paquete_id;estado;fecha;Limite Pago,;Fecha Confirmacion\n");
            
            for(Reserva r: GestorReserva.listaReservas) {
                fw.write(r.toCSV() + "\n");
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void leerReserva() {
        try(BufferedReader br = new BufferedReader(new FileReader("reserva.csv"))) {
            String linea = br.readLine();
            
            while((linea = br.readLine()) != null) {
                String[] valores = linea.split(";");
                
                String reservaId = valores[0];
                Cliente cliente = (Cliente) GestionUsuario.buscarUsuario(valores[1]);
                Evento evento = GestionEvento.buscarEvento(valores[2]);
                Paquete paquete = GestionPaquete.buscarPaquete(valores[3]);
                Estado estado = Estado.valueOf(valores[4]);
                LocalDateTime fechaLimite = LocalDateTime.parse(valores[5]);
                LocalDateTime fechaConfirmacion = LocalDateTime.parse(valores[6]);
                
                GestorReserva.listaReservas.add(
                new Reserva(reservaId, cliente, evento, paquete, estado, fechaLimite,
                fechaConfirmacion));
            }
            
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
