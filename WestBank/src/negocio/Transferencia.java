package negocio;

import java.time.LocalDateTime;

public class Transferencia {
    private int idTransaccion;
    private int montoTransferencia;
    private LocalDateTime  fechaHora;

    public Transferencia() {
    }

    public Transferencia(int idTransaccion, int montoTransferencia, LocalDateTime fechaHora) {
        this.idTransaccion = idTransaccion;
        this.montoTransferencia = montoTransferencia;
        this.fechaHora = fechaHora;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getMontoTransferencia() {
        return montoTransferencia;
    }

    public void setMontoTransferencia(int montoTransferencia) {
        this.montoTransferencia = montoTransferencia;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

 


}
