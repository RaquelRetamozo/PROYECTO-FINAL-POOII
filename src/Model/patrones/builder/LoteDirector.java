package Model.patrones.builder;

import Model.entidades.Lote;
import Model.entidades.Producto;

public class LoteDirector {

    //Atributos
    private LoteBuilder builder;

    //Constructor
    public LoteDirector(LoteBuilder builder) {
        this.builder = builder;
    }

    //Métodos
    public Lote construirLoteEstandar(String idLote, String numeroLote,
                                      Producto producto, int cantidad,
                                      String ubicacion) {
        return builder
                .idLote(idLote)
                .numeroLote(numeroLote)
                .producto(producto)
                .cantidad(cantidad)
                .ubicacion(ubicacion)
                .build();
    }

    public Lote construirLoteCuarentena(String idLote, String numeroLote,
                                        Producto producto, int cantidad,
                                        String ubicacion) {
        return builder
                .idLote(idLote)
                .numeroLote(numeroLote)
                .producto(producto)
                .cantidad(cantidad)
                .ubicacion(ubicacion)
                .estado("CUARENTENA")
                .build();
    }
}