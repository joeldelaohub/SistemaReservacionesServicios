package reserva.gestionclases;

import java.util.ArrayList;
import reserva.Factura;
import reserva.Reserva;

/**
 *
 * @author joeld
 */
public class GestionFactura {
    public static ArrayList<Factura> facturas = new ArrayList<>();
    
    public static Factura buscarFacturaReserva(Reserva reserva) {
        Factura factura = null; 
        
        for (int i = 0; i < facturas.size(); i++) {
            if(facturas.get(i).getReserva().equals(reserva)) {
                factura = facturas.get(i);
            }
        }
        
        return factura;
    }
    
    public static void guardarNumeroID() {
        int mayor = 0;
        
        if(facturas.isEmpty()) {
            Factura.contadorFacturas = mayor++;
        } else {
            
            for (int i = 0; i < facturas.size(); i++) {
            
                String id = facturas.get(i).getId().substring(2);
                int idNumero = Integer.parseInt(id);

                 if(idNumero > mayor) {
                     mayor = idNumero;
                 }
            }
            
             Factura.contadorFacturas = ++mayor;
        }
    }
}
