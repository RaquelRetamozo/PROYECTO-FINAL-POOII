package Model.patrones.strategy;

import Model.entidades.Despacho;
import java.util.ArrayList;
import java.util.List;

public class BusquedaPorCliente implements IEstrategiaBusqueda {

    //Métodos
    @Override
    public List<Despacho> buscar(List<Despacho> despachos, String idCliente) {
        List<Despacho> resultado = new ArrayList<>();
        for (Despacho d : despachos) {
            if (d.getCliente().getIdCliente().equals(idCliente)) {
                resultado.add(d);
            }
        }
        return resultado;
    }
}