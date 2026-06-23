package Model.entidades;
import java.time.LocalDateTime;

public class MovimientoInventario {
    //Atributos
    private String idMovimiento;
    private Lote lote;
    private String tipoMovimiento;  // INGRESO, SALIDA, AJUSTE
    private int cantidad;
    private LocalDateTime fechaHora;
    private String motivo;
    private String responsable;

    //Constructor
    public MovimientoInventario(String idMovimiento, Lote lote, String tipoMovimiento,
                                int cantidad, String motivo, String responsable) {
        this.idMovimiento = idMovimiento;
        this.lote = lote;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.fechaHora = LocalDateTime.now();
        this.motivo = motivo;
        this.responsable = responsable;
    }

    public boolean esIngreso() {
        return tipoMovimiento.equals("INGRESO");
    }

    public boolean esSalida() {
        return tipoMovimiento.equals("SALIDA");
    }

    // Getters
    public String getIdMovimiento() { return idMovimiento; }
    public Lote getLote() { return lote; }
    public String getTipoMovimiento() { return tipoMovimiento; }
    public int getCantidad() { return cantidad; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }
    public String getResponsable() { return responsable; }

    // Setters
    public void setIdMovimiento(String idMovimiento) { this.idMovimiento = idMovimiento; }
    public void setLote(Lote lote) { this.lote = lote; }
    public void setTipoMovimiento(String tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

}