/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemareservacionesservicios;

import catalogo.PaqueteCSV;
import catalogo.ServicioCSV;
import evento.EventoCSV;
import evento.ItinerarioCSV;
import reserva.FacturaCSV;
import reserva.ReservaCSV;
import sistemareservacionesservicios.usuario.UsuarioCSV;



/**
 *
 * @author joeld
 */
public class SistemaReservacionesServicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioCSV.leerUsuarios();
        ServicioCSV.leerServicios();
        EventoCSV.leerEventos();
        ItinerarioCSV.leerItinerario();
        PaqueteCSV.leerPaquetes();
        ReservaCSV.leerReserva();
        FacturaCSV.leerFacturas();
    }
    
}
