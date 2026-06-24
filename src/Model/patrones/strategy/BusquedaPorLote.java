package Model.patrones.strategy;

import Model.entidades.Despacho;
import java.util.ArrayList;
import java.util.List;

public class BusquedaPorLote implements IEstrategiaBusqueda {

    //Métodos
    @Override
    public List<Despacho> buscar(List<Despacho> despachos, String numeroLote) {
        List<Despacho> resultado = new ArrayList<>();
        for (Despacho d : despachos) {
            for (var detalle : d.getDetalles()) {
                if (detalle.getLote().getNumeroLote().equals(numeroLote)) {
                    resultado.add(d);
                    break;
                }
            }
        }
        return resultado;
    }
}