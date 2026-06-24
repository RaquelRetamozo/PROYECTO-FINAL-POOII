package Model.patrones.builder;

import Model.entidades.Cliente;
import Model.entidades.Despacho;
import Model.entidades.DetalleDespacho;
import Model.entidades.Transportista;
import java.time.LocalDate;

public class DespachoDirector {

    //Atributos
    private DespachoBuilder builder;

    //Constructor
    public DespachoDirector(DespachoBuilder builder) {
        this.builder = builder;
    }

    //Métodos
    public Despacho construirDespachoEstandar(String idDespacho, Cliente cliente,
                                              Transportista transportista,
                                              DetalleDespacho detalle) {
        return builder
                .idDespacho(idDespacho)
                .cliente(cliente)
                .transportista(transportista)
                .fechaDespacho(LocalDate.now())
                .agregarDetalle(detalle)
                .build();
    }

    public Despacho construirDespachoUrgente(String idDespacho, Cliente cliente,
                                             Transportista transportista,
                                             DetalleDespacho detalle) {
        return builder
                .idDespacho(idDespacho)
                .cliente(cliente)
                .transportista(transportista)
                .fechaDespacho(LocalDate.now())
                .observacion("DESPACHO URGENTE")
                .agregarDetalle(detalle)
                .build();
    }
}