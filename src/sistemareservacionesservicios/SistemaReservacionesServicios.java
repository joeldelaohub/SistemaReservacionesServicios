/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemareservacionesservicios;

import catalogo.PaqueteCSV;
import catalogo.ServicioCSV;
import catalogo.gestionclases.GestionPaquete;
import catalogo.gestionclases.GestionServicio;
import evento.EventoCSV;
import evento.ItinerarioCSV;
import evento.gestionclases.GestionEvento;
import evento.gestionclases.GestionItinerario;
import gui.PantallaPrincipal;
import reserva.FacturaCSV;
import reserva.GestorReserva;
import reserva.ReservaCSV;
import reserva.gestionclases.GestionFactura;
import sistemareservacionesservicios.usuario.GestionUsuario;
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
        
        try {
            PantallaPrincipal principal = new PantallaPrincipal();
            principal.setLocationRelativeTo(null);
            principal.setVisible(true);
        }catch(NullPointerException e) {
            StackTraceElement[] error = e.getStackTrace();
            
            for(StackTraceElement err: error) {
                System.out.println(err.toString());
            }
        }
        
        // actualizacion del ultimo registro mediante el ultimo numero del Id
        GestionUsuario.guardarNumeroID();
        GestionServicio.guardarNumeroID();
        GestionEvento.guardarNumeroID();
        GestionItinerario.guardarNumeroID();
        GestionPaquete.guardarNumeroID();
        GestorReserva.guardarNumeroID();
        GestionFactura.guardarNumeroID();   
    }
    
}
