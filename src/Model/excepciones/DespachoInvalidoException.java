package Model.excepciones;

public class DespachoInvalidoException extends CramerException {
    public DespachoInvalidoException(String idDespacho) {
        super("El despacho " + idDespacho + " no es válido.");
    }
}