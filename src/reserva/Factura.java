package reserva;

/**
 *
 * @author joeld
 */
public class Factura {
    private Reserva reserva;
    private double montoTotal;
    private double saldoRestante;
    private double saldoAnticipado;

    public Factura(Reserva reserva, double montoTotal, double saldoRestante, double saldoAnticipado) {
        this.reserva = reserva;
        this.montoTotal = montoTotal;
        this.saldoRestante = saldoRestante;
        this.saldoAnticipado = saldoAnticipado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(double saldoRestante) {
        this.saldoRestante = saldoRestante;
    }

    public double getSaldoAnticipado() {
        return saldoAnticipado;
    }

    public void setSaldoAnticipado(double saldoAnticipado) {
        this.saldoAnticipado = saldoAnticipado;
    }
    
    @Override
    public String toString() {
        return String.format("Reserva: %s%nMonto Total: %.2f%nSaldo Restante: %.2f%nSaldo Anticipado: %.2f%n", 
                reserva.getId(), montoTotal, saldoRestante, saldoAnticipado);
    }
}
