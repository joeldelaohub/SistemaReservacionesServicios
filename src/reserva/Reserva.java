package reserva;

import catalogo.Paquete;
import estados.Estado;
import evento.Evento;
import java.time.LocalDate;
import java.time.LocalDateTime;
import sistemareservacionesservicios.usuario.Cliente;

/**
 *
 * @author joeld
 */
public class Reserva {
    private final String id;
    private Cliente cliente;
    private Evento evento;
    private Paquete paquete;
    private Factura factura;
    private Estado estado;
    private LocalDateTime fechaLimitePago;
    private LocalDateTime fechaConfirmacion;
    private static int contadorReservas = 0;
    
    public Reserva(String id, Cliente cliente, Evento evento, Paquete paquete, Factura factura, 
            Estado estado, LocalDateTime fechaLimitePago, LocalDateTime fechaConfirmacion) {
        this.id = id;
        this.cliente = cliente;
        this.evento = evento;
        this.paquete = paquete;
        this.factura = factura;
        this.estado = estado;
        this.fechaLimitePago = fechaLimitePago;
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Reserva(String id, Cliente cliente, Evento evento, Paquete paquete, 
            LocalDateTime fechaLimitePago) {
        
       this(String.format("RE%02d", contadorReservas++), cliente, evento, paquete, null, Estado.PENDIENTE, fechaLimitePago, null);
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Factura getFactura() {
        return factura;
    }

    public Estado getEstado() {
        return estado;
    }

    public LocalDateTime getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(LocalDateTime fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public LocalDateTime getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(LocalDateTime fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }
    
    public void aprobar() {
        if(this.estado != Estado.PENDIENTE) 
            throw new IllegalArgumentException("La reserva ya ha sido aprobada, confirmada o cancelada");
        
        this.estado = Estado.APROBADA;
    }
    
    public void confirmar() {
        if(this.estado != Estado.APROBADA)
            throw new IllegalArgumentException("La reserva debe de ser aprobada primero.");
        
        if(this.factura == null) {
            throw new IllegalArgumentException("se debe se confirmar el anticipo para confirmar la reserva");
        }
        
        this.fechaConfirmacion = LocalDateTime.now();
        this.estado = Estado.CONFIRMADA;
    }
    
    public void finalizar() {
        if(this.estado != Estado.CONFIRMADA)
            throw new IllegalArgumentException("la reserva debe de estar confirmada para que pueda ser finalizada.");
        
        this.estado = Estado.FINALIZADA;
    }
    
    public void cancelarPorCliente() {
        if(this.estado == Estado.FINALIZADA || this.estado  == Estado.CANCELADA)
            throw new IllegalArgumentException("No puedes cancelar una reserva que ya finalizó o ha sido cancelada.");
        
        this.estado = Estado.CANCELADA;
    }
    
    public void cancelarPorAdmin() {
         if(this.estado == Estado.FINALIZADA || this.estado  == Estado.CANCELADA)
            throw new IllegalArgumentException("No puedes cancelar una reserva que ya finalizó o ha sido cancelada.");
        
        if(this.factura != null)
            this.factura.marcarReembolso();
            
        this.estado = Estado.CANCELADA;
    }
    
    public boolean validarModificacion() {
        boolean sePuedeModificar = false;
        
        if(this.estado == Estado.CANCELADA || this.estado == Estado.FINALIZADA) {
            sePuedeModificar = false;
        }
        
        if(this.estado == Estado.PENDIENTE) {
            sePuedeModificar = true;
        }
        
        if(this.estado == Estado.APROBADA) {
            sePuedeModificar = true;
        }
        
        if(this.estado == Estado.CONFIRMADA) {
            LocalDateTime rangoLimiteCambio = fechaConfirmacion.plusHours(24);
            
            if(rangoLimiteCambio.isAfter(LocalDateTime.now()))
                sePuedeModificar = true;
        }
        
            
        return sePuedeModificar;
    }
    
    @Override
    public String toString() {
        return String.format("Cliente: %s%nFecha de Evento: %s%nPaquete: %s%nEstado: %s%n", 
                cliente.getNombre(), evento.getFecha().toString(), paquete.getNombre(), estado.toString());
    }
}
