package entidades;
import java.time.LocalDate;

public class Lote {

    //Atributos
    private String idLote;
    private String numeroLote;
    private Producto producto;
    private int cantidad;
    private LocalDate fechaIngreso;
    private String ubicacion;
    private String estado;      // ACTIVO, VENCIDO, DESPACHADO, CUARENTENA

    //Constructor
    public Lote(String idLote, String numeroLote, Producto producto, int cantidad, LocalDate fechaIngreso, String ubicacion, String estado) {
        this.idLote = idLote;
        this.numeroLote = numeroLote;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    //Metodo
    public boolean estaVencido() {
        return producto.estaVencido();
    }

    //Getters
    public String getIdLote() {
        return idLote;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    //Setters
    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
