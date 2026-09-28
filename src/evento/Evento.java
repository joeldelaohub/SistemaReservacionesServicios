package evento;

import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author joeld
 */
public class Evento {
    private final String id;
    private LocalDate fecha;
    private int duracion;
    private String ubicacion;
    private String tipo;
    private LocalTime hora;
    
    public Evento(String id, LocalDate fecha, int duracion, String ubicacion,
            String tipo, LocalTime hora) {
        
        this.id = id;
        this.fecha = fecha;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.hora = hora;
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
} 
