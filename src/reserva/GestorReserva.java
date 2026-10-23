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
    public static ArrayList<Reserva> listaReservas = new ArrayList<>();
    
    public static boolean validarFecha(Reserva reserva, Evento evento) {
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
    
    public static void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }
    
    public static void eliminarReserva( int indice) {
        listaReservas.remove(indice);
    }
    
    public static void modificarReserva(Reserva reserva, Evento evento) {
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
    
    public static ArrayList<Reserva> buscarReservasCliente(Cliente cliente) {
        ArrayList<Reserva> reservasCliente = new ArrayList<>();
        
        for (int i = 0; i < listaReservas.size(); i++) {
            if(listaReservas.get(i).getCliente().getId().equals(cliente.getId())) {
                reservasCliente.add(listaReservas.get(i));
            }
        }
        
        return reservasCliente;
    }
    
    public static Reserva buscarReserva(String id) {
        Reserva reservaEncontrada = null;
        
        for (int i = 0; i < listaReservas.size(); i++) {
            if(listaReservas.get(i).getId().equals(id)) {
                reservaEncontrada = listaReservas.get(i);
            }
        }
        
        return reservaEncontrada;
    }
    
    public static void guardarNumeroID() {
        int mayor = 0;
        
        if(listaReservas.isEmpty()) {
            Reserva.contadorReservas = mayor++;
        } else {
            
            for (int i = 0; i < listaReservas.size(); i++) {
            
                String id = listaReservas.get(i).getId().substring(2);
                int idNumero = Integer.parseInt(id);

                 if(idNumero > mayor) {
                     mayor = idNumero;
                 }
            }
            
             Reserva.contadorReservas = ++mayor;
        }
    }
}
