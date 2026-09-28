package reserva;

import java.util.ArrayList;

/**
 *
 * @author joeld
 */
public class GestorReserva {
    public static ArrayList<Reserva> listaReservas;
    
    public void validarFecha() {
        
    }
    
    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }
    
    public void eliminarReserva(Reserva reserva) {
        listaReservas.remove(reserva);
    }
    
    public void modificarReserva() {
        
    }
    
    public void listarReservas() {
        
    }
    
    public void buscarReservasCliente() {
        
    }
}
