package Model.entidades;
import java.time.LocalDate;

public abstract class Producto {

    //Atributos
    private String idProducto;
    private String nombre;
    private LocalDate fechaFabricacion;
    private LocalDate fechaVencimiento;
    private double cantidad;
    private String dosis;

    //Constructor
    public Producto(String idProducto, String nombre, LocalDate fechaFabricacion, LocalDate fechaVencimiento, double cantidad, String dosis) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.dosis = dosis;
    }

    //Metodos
    public abstract String getTipo();

    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaVencimiento);
    }

    //Getters
    public String getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDosis() {
        return dosis;
    }

    //Setters

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

}
