package Model.patrones.strategy;

import Model.entidades.Despacho;
import java.util.ArrayList;
import java.util.List;

public class BusquedaPorFecha implements IEstrategiaBusqueda {

    //Métodos
    @Override
    public List<Despacho> buscar(List<Despacho> despachos, String fecha) {
        List<Despacho> resultado = new ArrayList<>();
        for (Despacho d : despachos) {
            if (d.getFechaDespacho().toString().equals(fecha)) {
                resultado.add(d);
            }
        }
        return resultado;
    }
}