package Model.excepciones;

public class ClienteNoEncontradoException extends CramerException {
    public ClienteNoEncontradoException(String idCliente) {
        super("No se encontró el cliente con ID: " + idCliente + ".");
    }
}