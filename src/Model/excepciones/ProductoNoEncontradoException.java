package Model.excepciones;

public class ProductoNoEncontradoException extends CramerException {
  public ProductoNoEncontradoException(String idProducto) {
    super("No se encontró el producto con ID: " + idProducto + ".");
  }
}