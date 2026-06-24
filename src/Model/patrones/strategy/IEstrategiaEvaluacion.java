package Model.patrones.strategy;

import Model.entidades.ZonaAlmacen;

public interface IEstrategiaEvaluacion {
    boolean evaluar(ZonaAlmacen zona, double valor);
    String getMensaje();
}