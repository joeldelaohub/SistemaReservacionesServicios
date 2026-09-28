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
    
    public Itinerario(String id, LocalTime horaMontaje, LocalTime horaPruebaSonido, Evento evento) {
        this.id = id;
        this.horaMontaje = horaMontaje;
        this.horaPruebaSonido = horaPruebaSonido;
        this.evento = evento;
    }

    public String getId() {
        return id;
    }

    public LocalTime getHoraMontaje() {
        return horaMontaje;
    }

    public void setHoraMontaje(LocalTime horaMontaje) {
        this.horaMontaje = horaMontaje;
    }

    public LocalTime getHoraPruebaSonido() {
        return horaPruebaSonido;
    }

    public void setHoraPruebaSonido(LocalTime horaPruebaSonido) {
        this.horaPruebaSonido = horaPruebaSonido;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
