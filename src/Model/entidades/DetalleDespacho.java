package Model.entidades;

public class DetalleDespacho {

    //Atributos
    private String idDetalle;
    private Despacho despacho;
    private Lote lote;
    private int cantidad;
    private double precioUnitario;

    //Constructor
    public DetalleDespacho(String idDetalle, Despacho despacho,
                           Lote lote, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.despacho = despacho;
        this.lote = lote;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    // Getters
    public String getIdDetalle() { return idDetalle; }
    public Despacho getDespacho() { return despacho; }
    public Lote getLote() { return lote; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    // Setters
    public void setIdDetalle(String idDetalle) { this.idDetalle = idDetalle; }
    public void setDespacho(Despacho despacho) { this.despacho = despacho; }
    public void setLote(Lote lote) { this.lote = lote; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

}