package Model.entidades;
import java.time.LocalDate;

public class Reclamo {

    //Atributos
    private String idReclamo;
    private Cliente cliente;
    private Lote lote;
    private String motivo;
    private String descripcion;
    private String estado;          // PENDIENTE, EN_PROCESO, RESUELTO, CERRADO
    private LocalDate fechaReclamo;
    private LocalDate fechaResolucion;
    private String responsable;

    //Constructor
    public Reclamo(String idReclamo, Cliente cliente, Lote lote,
                   String motivo, String descripcion, String responsable) {
        this.idReclamo = idReclamo;
        this.cliente = cliente;
        this.lote = lote;
        this.motivo = motivo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.estado = "PENDIENTE";
        this.fechaReclamo = LocalDate.now();
        this.fechaResolucion = null;
    }

    //Métodos
    public void resolver() {
        this.estado = "RESUELTO";
        this.fechaResolucion = LocalDate.now();
    }

    public void cerrar() {
        this.estado = "CERRADO";
    }

    public boolean estaResuelto() {
        return estado.equals("RESUELTO") || estado.equals("CERRADO");
    }

    //Getters
    public String getIdReclamo() { return idReclamo; }
    public Cliente getCliente() { return cliente; }
    public Lote getLote() { return lote; }
    public String getMotivo() { return motivo; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public LocalDate getFechaReclamo() { return fechaReclamo; }
    public LocalDate getFechaResolucion() { return fechaResolucion; }
    public String getResponsable() { return responsable; }

    //Setters
    public void setIdReclamo(String idReclamo) { this.idReclamo = idReclamo; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setLote(Lote lote) { this.lote = lote; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setFechaResolucion(LocalDate fechaResolucion) { this.fechaResolucion = fechaResolucion; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}
