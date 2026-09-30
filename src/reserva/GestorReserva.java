package reserva;

import estados.Estado;
import evento.Evento;
import java.util.ArrayList;
import sistemareservacionesservicios.usuario.Cliente;

/**
 *
 * @author joeld
 */
public class GestorReserva {
    public static ArrayList<Reserva> listaReservas;
    
    public boolean validarFecha(Reserva reserva, Evento evento) {
        boolean sePuedeCambiar = true;
        
        for (int i = 0; i < listaReservas.size(); i++) {
                
            if(listaReservas.get(i).equals(reserva)) {
                continue;
            } // fin del primer if interno
                
            if(listaReservas.get(i).getEvento().getFecha().equals(evento.getFecha()) &&
                listaReservas.get(i).getEvento().getHora().equals(evento.getHora()) && 
                (listaReservas.get(i).getEstado() == Estado.APROBADA || listaReservas.get(i).getEstado() == Estado.CONFIRMADA)) 
            {
                    sePuedeCambiar = false;
            } // fin del segundo if interno
            
        } // fin del for
         
        return sePuedeCambiar;
    }
    
    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }
    
    public void eliminarReserva(Reserva reserva) {
        listaReservas.remove(reserva);
    }
    
    public void modificarReserva(Reserva reserva, Evento evento) {
       if(reserva.validarModificacion()) {
           if(validarFecha(reserva, evento)) {
               reserva.setEvento(evento);
           } else {
               throw new IllegalArgumentException("la fecha ya esta ocupada.");
           }
       } else {
           throw new IllegalArgumentException("No se puede modificar.");
       }
    }
    
    public ArrayList<Reserva> listarReservas() {
        return this.listaReservas;
    }
    
    public ArrayList<Reserva> buscarReservasCliente(Cliente cliente) {
        ArrayList<Reserva> reservasCliente = new ArrayList<>();
        
        for (int i = 0; i < listaReservas.size(); i++) {
            if(listaReservas.get(i).getCliente().getId().equals(cliente.getId())) {
                reservasCliente.add(listaReservas.get(i));
            }
        }
        
        return reservasCliente;
    }
}
