package Model.patrones.strategy;

import Model.entidades.ZonaAlmacen;

public class EvaluacionHumedad implements IEstrategiaEvaluacion {

    //Atributos
    private String mensaje;

    //Constructor
    public EvaluacionHumedad() {
        this.mensaje = "";
    }

    //Métodos
    @Override
    public boolean evaluar(ZonaAlmacen zona, double valor) {
        if (zona.humedadEnRango(valor)) {
            mensaje = "Humedad " + valor + "% dentro del rango permitido.";
            return true;
        }
        mensaje = "Humedad " + valor + "% FUERA del rango permitido: " +
                zona.getHumedadMin() + "% - " + zona.getHumedadMax() + "%";
        return false;
    }

    @Override
    public String getMensaje() { return mensaje; }
}