package Model.patrones.builder;

import Model.entidades.Lote;
import Model.entidades.Producto;
import java.time.LocalDate;

public class LoteBuilder {

    //Atributos
    private String idLote;
    private String numeroLote;
    private Producto producto;
    private int cantidad;
    private LocalDate fechaIngreso;
    private String ubicacion;
    private String estado;

    //Constructor
    public LoteBuilder() {
        this.fechaIngreso = LocalDate.now();
        this.estado = "ACTIVO";
    }

    //Métodos
    public LoteBuilder idLote(String idLote) {
        this.idLote = idLote;
        return this;
    }

    public LoteBuilder numeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
        return this;
    }

    public LoteBuilder producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public LoteBuilder cantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public LoteBuilder fechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public LoteBuilder ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
        return this;
    }

    public LoteBuilder estado(String estado) {
        this.estado = estado;
        return this;
    }

    public Lote build() {
        return new Lote(idLote, numeroLote, producto,
                cantidad, fechaIngreso, ubicacion, estado);
    }
}