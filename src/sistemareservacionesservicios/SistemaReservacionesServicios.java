/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemareservacionesservicios;

import catalogo.PaqueteCSV;
import catalogo.ServicioCSV;
import evento.EventoCSV;
import evento.ItinerarioCSV;
import evento.gestionclases.GestionEvento;
import gui.PantallaPrincipal;
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
        
        // lectura de los Csv
        UsuarioCSV.leerUsuarios();
        ServicioCSV.leerServicios();
        EventoCSV.leerEventos();
        ItinerarioCSV.leerItinerario();
        PaqueteCSV.leerPaquetes();
        ReservaCSV.leerReserva();
        FacturaCSV.leerFacturas();
        
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        
        // actualizacion del ultimo registro mediante el ultimo numero del Id
        GestionEvento.guardarNumeroID();
    }
    
}
