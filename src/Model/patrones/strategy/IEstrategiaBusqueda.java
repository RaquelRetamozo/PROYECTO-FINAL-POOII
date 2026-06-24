package Model.patrones.strategy;

import Model.entidades.Despacho;
import java.util.List;

public interface IEstrategiaBusqueda {
    List<Despacho> buscar(List<Despacho> despachos, String criterio);
}