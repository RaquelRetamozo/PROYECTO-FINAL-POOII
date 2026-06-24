package Model.patrones.strategy;

import Model.entidades.ZonaAlmacen;

public class EvaluacionTemperatura implements IEstrategiaEvaluacion {

    //Atributos
    private String mensaje;

    //Constructor
    public EvaluacionTemperatura() {
        this.mensaje = "";
    }

    //Métodos
    @Override
    public boolean evaluar(ZonaAlmacen zona, double valor) {
        if (zona.temperaturaEnRango(valor)) {
            mensaje = "Temperatura " + valor + "°C dentro del rango permitido.";
            return true;
        }
        mensaje = "Temperatura " + valor + "°C FUERA del rango permitido: " +
                zona.getTemperaturaMin() + "°C - " + zona.getTemperaturaMax() + "°C";
        return false;
    }

    @Override
    public String getMensaje() { return mensaje; }
}