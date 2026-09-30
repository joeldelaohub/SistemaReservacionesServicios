package evento;

import java.time.LocalTime;

/**
 *
 * @author joeld
 */
public class Itinerario {
    private final String id;
    private LocalTime horaMontaje;
    private LocalTime horaPruebaSonido;
    private Evento evento;
    private final int MIN_HORA_MONTAJE = 2;
    private final int MIN_HORA_PRUEBA_SONIDO = 1;
    
    public Itinerario(String id, LocalTime horaMontaje, LocalTime horaPruebaSonido, Evento evento) {
        if(horaMontaje.isAfter(evento.getHora().minusHours(MIN_HORA_MONTAJE))) {
            throw new IllegalArgumentException("la hora del montaje debe ser minimo 2 horas antes del evento");
        }
        
        if(horaMontaje.isAfter(horaPruebaSonido)) {
            throw new IllegalArgumentException("La hora del montaje debe ser antes que la prueba del sonido");
        }
        
        if(horaPruebaSonido.isAfter(evento.getHora().minusHours(MIN_HORA_PRUEBA_SONIDO))) {
            throw new IllegalArgumentException("la hora de la prueba de sonido debe ser minimo 1 hora antes del evento");
        }
        
        this.id = id;
        this.evento = evento;
        this.horaMontaje = horaMontaje;
        this.horaPruebaSonido = horaPruebaSonido;
    }
    
    public Itinerario(String id, Evento evento) {
        this(id, evento.getHora().minusHours(2), evento.getHora().minusHours(1), evento);
    }
    
    public String getId() {
        return id;
    }

    public LocalTime getHoraMontaje() {
        return horaMontaje;
    }

    public void setHoraMontaje(LocalTime horaMontaje) {
        if(horaMontaje.isAfter(evento.getHora().minusHours(MIN_HORA_MONTAJE))) {
            throw new IllegalArgumentException("la hora del montaje debe ser minimo 2 horas antes del evento");
        }
        
        if(!horaMontaje.isAfter(horaPruebaSonido)) {
           throw new IllegalArgumentException("La hora del montaje debe ser antes que la prueba del sonido");
        }
        
        this.horaMontaje = horaMontaje;
    }

    public LocalTime getHoraPruebaSonido() {
        return horaPruebaSonido;
    }

    public void setHoraPruebaSonido(LocalTime horaPruebaSonido) {
        if(horaPruebaSonido.isAfter(evento.getHora().minusHours(MIN_HORA_PRUEBA_SONIDO))) {
            throw new IllegalArgumentException("la hora de la prueba de sonido debe ser minimo 1 hora antes del evento");
        }
        
        if(!horaPruebaSonido.isBefore(horaMontaje)) {
           throw new IllegalArgumentException("La hora de la prueba de sonido debe ser despues de la hora del montaje");
        }
        this.horaPruebaSonido = horaPruebaSonido;
    }

    public Evento getEvento() {
        return evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    @Override
    public String toString() {
        return String.format("Hora de Montaje: %s%nHora de Prueba de Sonido: %s%nFecha y hora del Evento: %s %s%n",
                horaMontaje.toString(), horaPruebaSonido.toString(), evento.getFecha().toString(), evento.getHora().toString());
    }
}
