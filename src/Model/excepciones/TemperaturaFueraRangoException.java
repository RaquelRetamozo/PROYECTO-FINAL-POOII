package Model.excepciones;

public class TemperaturaFueraRangoException extends CramerException {
    public TemperaturaFueraRangoException(double temperatura) {
        super("Temperatura fuera de rango: " + temperatura + "°C.");
    }
}