package Model.patrones.builder;

import Model.entidades.Cliente;
import Model.entidades.Despacho;
import Model.entidades.DetalleDespacho;
import Model.entidades.Transportista;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DespachoBuilder {

    //Atributos
    private String idDespacho;
    private Cliente cliente;
    private Transportista transportista;
    private LocalDate fechaDespacho;
    private String observacion;
    private List<DetalleDespacho> detalles;

    //Constructor
    public DespachoBuilder() {
        this.fechaDespacho = LocalDate.now();
        this.detalles = new ArrayList<>();
        this.observacion = "";
    }

    //Métodos
    public DespachoBuilder idDespacho(String idDespacho) {
        this.idDespacho = idDespacho;
        return this;
    }

    public DespachoBuilder cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public DespachoBuilder transportista(Transportista transportista) {
        this.transportista = transportista;
        return this;
    }

    public DespachoBuilder fechaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
        return this;
    }

    public DespachoBuilder observacion(String observacion) {
        this.observacion = observacion;
        return this;
    }

    public DespachoBuilder agregarDetalle(DetalleDespacho detalle) {
        this.detalles.add(detalle);
        return this;
    }

    public Despacho build() {
        Despacho despacho = new Despacho(idDespacho, cliente, transportista,
                fechaDespacho, observacion);
        for (DetalleDespacho d : detalles) {
            despacho.agregarDetalle(d);
        }
        return despacho;
    }
}