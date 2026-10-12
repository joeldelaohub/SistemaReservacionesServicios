package evento;

import auth.Auth;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author joeld
 */
public class Evento {
    private final String id;
    private String clienteId;
    private LocalDate fecha;
    private int duracion;
    private String ubicacion;
    private String tipo;
    private LocalTime hora;
    public static int contadorEventos = 0;
    
    public Evento(String id, String clienteId, LocalDate fecha, int duracion, String ubicacion,
            String tipo, LocalTime hora) {
        
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.hora = hora;
    }
    
     public Evento(LocalDate fecha, int duracion, String ubicacion,
            String tipo, LocalTime hora) {
  
        if(fecha.isEqual(LocalDate.now()) || fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("fecha del evento no puede ser para el dia actual o dias pasados");
        }
        
        if(duracion <= 0)
            throw new IllegalArgumentException("la duracion no puede ser menor o igual a cero");
        
        if(ubicacion.isEmpty())
            throw new IllegalArgumentException("ubicacion no puede estar vacia");
        
        if(tipo.isEmpty())
            throw new IllegalArgumentException("tipo de evento no puede estar vacia");
        
        if(hora == null)
            throw new IllegalArgumentException("hora no puede estar vacia");
            
        
        this.id = String.format("EV%02d", contadorEventos++);
        this.clienteId = Auth.usuarioLogueado.getId();
        this.fecha = fecha;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.hora = hora;
    }
    
    public String getClienteId() {
        return clienteId;
    }
    
    public String getId() {
        return id;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString() {
        return String.format("fecha: %s%nDuracion: %d%nUbicacion: %s%nTipo: %s%nHora: %s%n",
                fecha.toString(), duracion, ubicacion, tipo, hora.toString());
    }
    
    public String toCSV() {
        return String.join(";", id, clienteId, fecha.toString(), String.valueOf(duracion), ubicacion,
                tipo, hora.toString());
    }
}
