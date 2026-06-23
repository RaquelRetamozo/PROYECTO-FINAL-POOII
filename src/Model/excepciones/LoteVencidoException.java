package Model.excepciones;

public class LoteVencidoException extends CramerException {
    public LoteVencidoException(String idLote) {
        super("El lote " + idLote + " se encuentra vencido.");
    }
}