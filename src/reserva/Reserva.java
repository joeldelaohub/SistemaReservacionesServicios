package reserva;

import catalogo.Paquete;
import estados.Estado;
import evento.Evento;
import java.time.LocalDate;
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
    private LocalDate fechaLimitePago;
    private LocalDate fechaConfirmacion;

    public Reserva(String id, Cliente cliente, Evento evento, Paquete paquete, Factura factura, 
            Estado estado, LocalDate fechaLimitePago, LocalDate fechaConfirmacion) {
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
            Estado estado, LocalDate fechaLimitePago, LocalDate fechaConfirmacion) {
        
       this(id, cliente, evento, paquete, null, estado, fechaLimitePago, fechaConfirmacion);
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

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(LocalDate fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public LocalDate getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(LocalDate fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s%nFecha de Evento: %s%nPaquete: %s%n", 
                cliente.getNombre(), evento.getFecha().toString(), paquete.getNombre());
    }
}
