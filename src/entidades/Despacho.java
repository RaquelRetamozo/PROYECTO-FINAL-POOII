package entidades;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Despacho {

    //Atributos
    private String idDespacho;
    private Cliente cliente;
    private Transportista transportista;
    private LocalDate fechaDespacho;
    private String estado;      // PENDIENTE, EN_PROCESO, ENTREGADO, CANCELADO
    private String observacion;
    private List<DetalleDespacho> detalles;

    //Constructor
    public Despacho(String idDespacho, Cliente cliente, Transportista transportista,
                    LocalDate fechaDespacho, String observacion) {
        this.idDespacho = idDespacho;
        this.cliente = cliente;
        this.transportista = transportista;
        this.fechaDespacho = fechaDespacho;
        this.observacion = observacion;
        this.estado = "PENDIENTE";
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleDespacho detalle) {
        detalles.add(detalle);
    }

    public double getTotalDespacho() {
        double total = 0;
        for (DetalleDespacho d : detalles) {
            total += d.getSubtotal();
        }
        return total;
    }

    // Getters
    public String getIdDespacho() { return idDespacho; }
    public Cliente getCliente() { return cliente; }
    public Transportista getTransportista() { return transportista; }
    public LocalDate getFechaDespacho() { return fechaDespacho; }
    public String getEstado() { return estado; }
    public String getObservacion() { return observacion; }
    public List<DetalleDespacho> getDetalles() { return detalles; }

    // Setters
    public void setIdDespacho(String idDespacho) { this.idDespacho = idDespacho; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setTransportista(Transportista transportista) { this.transportista = transportista; }
    public void setFechaDespacho(LocalDate fechaDespacho) { this.fechaDespacho = fechaDespacho; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    @Override
    public String toString() {
        return "Despacho: " + idDespacho +
                " | Cliente: " + cliente.getRazonSocial() +
                " | Transportista: " + transportista.getNombre() +
                " | Fecha: " + fechaDespacho +
                " | Estado: " + estado +
                " | Total: S/." + getTotalDespacho();
    }
}
