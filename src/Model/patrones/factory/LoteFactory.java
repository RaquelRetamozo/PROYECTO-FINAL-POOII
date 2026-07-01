package Model.patrones.factory;

import Model.entidades.Lote;
import Model.entidades.Producto;
import java.time.LocalDate;

public class LoteFactory {

    //Métodos
    public static Lote crear(String idLote, String numeroLote, Producto producto,
                             int cantidad, String ubicacion) {
        return new Lote(idLote, numeroLote, producto, cantidad,
                LocalDate.now(), ubicacion, "ACTIVO");
    }
}