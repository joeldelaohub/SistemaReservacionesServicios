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
    private boolean reembolso;
    private String id;
    private static int contadorFacturas = 0;
    
    public Factura(String id, Reserva reserva, double montoTotal, double saldoAnticipado) {
        if(saldoAnticipado < (montoTotal * 0.30)) {
            throw new IllegalArgumentException("el saldo anticipado debe ser mayor o igual al 30%");
        }
        this.id = id;
        this.reserva = reserva;
        this.montoTotal = montoTotal;
        this.saldoAnticipado = saldoAnticipado;
        this.saldoRestante = this.montoTotal - this.saldoAnticipado;
        this.reembolso = false;
    }
    
    public Factura(Reserva reserva, double montoTotal, double saldoAnticipado) {
        if(saldoAnticipado < (montoTotal * 0.30)) {
            throw new IllegalArgumentException("el saldo anticipado debe ser mayor o igual al 30%");
        }
        this.id = String.format("FA%02d", contadorFacturas++);
        this.reserva = reserva;
        this.montoTotal = montoTotal;
        this.saldoAnticipado = saldoAnticipado;
        this.saldoRestante = this.montoTotal - this.saldoAnticipado;
        this.reembolso = false;
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
        if(saldoAnticipado < (montoTotal * 0.30)) {
            throw new IllegalArgumentException("el saldo anticipado debe ser mayor o igual al 30%");
        }
        
        this.saldoAnticipado = saldoAnticipado;
    }
    
    public boolean isReembolso() {
        return reembolso;
    }
    
    public void marcarReembolso() {
        this.reembolso = true;
    }
    
    @Override
    public String toString() {
        return String.format("Reserva: %s%nMonto Total: %.2f%nSaldo Restante: %.2f%nSaldo Anticipado: %.2f%nReembolso: %s%n", 
                reserva.getId(), montoTotal, saldoRestante, saldoAnticipado,
                reembolso ? "Se reembolso": "Sin reembolso");
    }
    
    public String toCSV() {
        return String.join(";", id, reserva.getId(), String.valueOf(montoTotal),
                String.valueOf(saldoAnticipado));
    }
}
