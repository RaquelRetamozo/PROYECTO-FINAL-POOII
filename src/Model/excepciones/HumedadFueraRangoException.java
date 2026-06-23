package Model.excepciones;

public class HumedadFueraRangoException extends CramerException {
    public HumedadFueraRangoException(double humedad) {
        super("Humedad fuera de rango: " + humedad + "%.");
    }
}