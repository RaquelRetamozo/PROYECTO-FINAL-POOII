package Model.patrones.factory;

import Model.enums.TipoAlerta;

public class AlertaFactory {

    //Métodos
    public static String crear(TipoAlerta tipo) {
        switch (tipo) {
            case VENCIMIENTO:
                return "⚠ ALERTA VENCIMIENTO: " + detalle;
            case AGOTADO:
                return "⚠ ALERTA STOCK AGOTADO: " + detalle;
            case TEMPERATURA:
                return "⚠ ALERTA TEMPERATURA: " + detalle;
            case HUMEDAD:
                return "⚠ ALERTA HUMEDAD: " + detalle;
            default:
                throw new IllegalArgumentException("Tipo de alerta no válido: " + tipo);
        }
    }
}