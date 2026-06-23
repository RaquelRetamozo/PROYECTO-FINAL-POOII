package Model.excepciones;

public class StockInsuficienteException extends CramerException {
    public StockInsuficienteException(String idProducto) {
        super("Stock insuficiente para el producto " + idProducto + ".");
    }
}